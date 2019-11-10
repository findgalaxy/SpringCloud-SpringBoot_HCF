package com.hand.hcf.app.fund.externalApi;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.hcf.app.apply.payment.PaymentClient;
import com.hand.hcf.app.apply.payment.dto.CashFlowItemCO;
import com.hand.hcf.app.apply.payment.dto.CashTransactionDetailCO;
import com.hand.hcf.app.client.attachment.AttachmentCO;
import com.hand.hcf.app.client.attachment.AttachmentClient;
import com.hand.hcf.app.client.org.OrganizationClient;
import com.hand.hcf.app.client.org.SysCodeValueCO;
import com.hand.hcf.app.mdata.base.util.OrgInformationUtil;
import com.hand.hcf.app.mdata.client.account.AccountClient;
import com.hand.hcf.app.mdata.client.account.AccountsCO;
import com.hand.hcf.app.mdata.client.bank.BankInterface;
import com.hand.hcf.app.mdata.client.bank.dto.BankInfoDTO;
import com.hand.hcf.app.mdata.client.com.CompanyCO;
import com.hand.hcf.app.mdata.client.com.CompanyClient;
import com.hand.hcf.app.mdata.client.contact.*;
import com.hand.hcf.app.mdata.client.currency.CurrencyClient;
import com.hand.hcf.app.mdata.client.currency.CurrencyRateCO;
import com.hand.hcf.app.mdata.client.department.DepartmentCO;
import com.hand.hcf.app.mdata.client.department.DepartmentClient;
import com.hand.hcf.app.mdata.client.dimension.DimensionCO;
import com.hand.hcf.app.mdata.client.dimension.DimensionClient;
import com.hand.hcf.app.mdata.client.dimension.DimensionDetailCO;
import com.hand.hcf.app.mdata.client.dimension.DimensionItemCO;
import com.hand.hcf.app.mdata.client.location.LocalizationInterface;
import com.hand.hcf.app.mdata.client.location.LocationInterface;
import com.hand.hcf.app.mdata.client.location.dto.LocalizationDTO;
import com.hand.hcf.app.mdata.client.location.dto.LocationDTO;
import com.hand.hcf.app.mdata.client.period.PeriodCO;
import com.hand.hcf.app.mdata.client.period.PeriodClient;
import com.hand.hcf.app.mdata.client.sob.SetOfBooksInfoCO;
import com.hand.hcf.app.mdata.client.sob.SobClient;
import com.hand.hcf.app.mdata.client.workflow.WorkflowClient;
import com.hand.hcf.app.mdata.client.workflow.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织架构三方接口
 * </p>
 *
 * @Author: bin.xie
 * @Date: 2018/12/24
 */
@Service
public class OrganizationService {

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private ContactClient userClient;

    @Autowired
    private SobClient sobClient;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private CurrencyClient currencyClient;
    @Autowired
    private AttachmentClient attachmentClient;
    @Autowired
    private PeriodClient periodClient;
    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private DimensionClient dimensionClient;

    @Autowired
    private WorkflowClient workflowClient;

    @Autowired
    private LocationInterface locationInterface;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private LocalizationInterface localizationInterface;

    @Autowired
    private BankInterface bankInterface;

    public Map<Long, CompanyCO> getCompanyMapByCompanyIds(List<Long> ids) {
        List<CompanyCO> companyCOS = companyClient.listByIds(ids);
        if (CollectionUtils.isEmpty(companyCOS)) {
            return new HashMap<>(16);
        }
        return companyCOS.stream().collect(Collectors.toMap(CompanyCO::getId, e -> e, (k1, k2) -> k1));
    }

    public Map<String, CompanyCO> listBySetOfBooksIdAndCompanyCodes(List<String> companyCodes) {
        List<CompanyCO> companyCOS = companyClient.listBySetOfBooksIdAndCompanyCodes(OrgInformationUtil.getCurrentSetOfBookId(),companyCodes);
        if (CollectionUtils.isEmpty(companyCOS)) {
            return new HashMap<>(16);
        }
        return companyCOS.stream().collect(Collectors.toMap(CompanyCO::getCompanyCode, e -> e, (k1, k2) -> k1));
    }

    public Map<Long, ContactCO> getUserMapByUserIds(List<Long> ids) {
        List<ContactCO> userCOS = userClient.listByUserIds(ids);
        if (CollectionUtils.isEmpty(userCOS)) {
            return new HashMap<>(16);
        }
        return userCOS.stream().collect(Collectors.toMap(ContactCO::getId, e -> e, (k1, k2) -> k1));
    }

    /**
     * 员工条件模糊查询
     *
     * @param employeeCode
     * @param fullName
     * @param page
     * @return
     */
    public List<ContactCO> pageConditionNameAndIgnoreIds(String employeeCode, String fullName, Page page) {

        List<ContactCO> userCOS = userClient.pageConditionNameAndIgnoreIds(employeeCode, fullName, fullName, new ArrayList<>(), page).getRecords();
        if (CollectionUtils.isEmpty(userCOS)) {
            return new ArrayList<>(16);
        }
        return userCOS;
    }


    public Map<Long, DepartmentCO> getDepartmentMapByDepartmentIds(List<Long> ids) {
        List<DepartmentCO> departmentCOS = departmentClient.listDepartmentsByIds(ids);
        if (CollectionUtils.isEmpty(departmentCOS)) {
            return new HashMap<>(16);
        }
        return departmentCOS.stream().collect(Collectors.toMap(DepartmentCO::getId, e -> e, (k1, k2) -> k1));
    }

    /**
     * 根据账套id获取账套信息，如果不存在则根据参数决定是否创建一个对象
     *
     * @param id
     * @return
     */
    public SetOfBooksInfoCO getSetOfBooksInfoCOById(Long id, boolean isNullNew) {
        SetOfBooksInfoCO setOfBooksInfoCO = sobClient.getSetOfBooksById(id);
        if (isNullNew) {
            if (setOfBooksInfoCO == null) {
                SetOfBooksInfoCO result = new SetOfBooksInfoCO();
                result.setId(id);
                return result;
            }
        }
        return setOfBooksInfoCO;
    }

    public DepartmentCO getDepartmentById(Long id) {
        return departmentClient.getDepartmentById(id);
    }

    public Map<Long, UserGroupCO> getUserGroupMapByGroupIds(List<Long> ids) {
        List<UserGroupCO> userGroupCOS = userClient.listUserGroupByUserGroupIds(ids);
        if (CollectionUtils.isEmpty(userGroupCOS)) {
            return new HashMap<>(16);
        }
        return userGroupCOS.stream().collect(Collectors.toMap(UserGroupCO::getId, e -> e, (k1, k2) -> k1));
    }

    /**
     * 根据本币种代码查询币种信息
     *
     * @param code
     * @param otherCode
     * @param setOfBooksId
     * @return
     */
    public CurrencyRateCO getForeignCurrencyByCode(String code, String otherCode, Long setOfBooksId) {
        return currencyClient.getForeignCurrencyByCode(code, otherCode, setOfBooksId);
    }

    public List<AttachmentCO> listAttachmentsByOids(List<String> oids) {
        return attachmentClient.listByOids(oids);
    }

    public void deleteAttachmentsByOids(List<String> oids) {
        attachmentClient.deleteByOids(oids);
    }

    public ContactCO getUserById(Long id) {
        return userClient.getById(id);
    }

    public List<CompanyCO> listCompanyBySetOfBooksId(Long setOfBooksId, Boolean enabled) {
        List<CompanyCO> companyCOS = companyClient.listBySetOfBooksIdConditionByEnabled(setOfBooksId, enabled);
        return companyCOS;
    }

    public List<DepartmentCO> listDepartmentsByTenantId() {
        Page<DepartmentCO> page = new Page<>(1, 100000);
        Page<DepartmentCO> departmentInfoByTenantId = departmentClient.pageDepartmentInfoByTenantId(null, page);
        if (page.getRecords() == null) {
            return new ArrayList<>();
        }
        return page.getRecords();
    }

    public Page<CompanyCO> pageCompanyByCond(Long setOfBooksId,
                                             String companyCode,
                                             String companyName,
                                             String companyCodeFrom,
                                             String companyCodeTo,
                                             List<Long> ignoreIds,
                                             Page page) {
        return companyClient.pageBySetOfBooksIdConditionByIgnoreIds(setOfBooksId, companyCode, companyCodeFrom, companyCodeTo, companyName, true, page, ignoreIds);
    }

    public DepartmentCO getDepartementCOByUserOid(String userOid) {
        return departmentClient.getDepartmentByEmpOid(userOid);
    }

    public Boolean judgeUserInUserGroups(JudgeUserCO judgeUserCO) {
        return userClient.judgeUserInUserGroups(judgeUserCO);
    }

    public PeriodCO getPeriodsByIDAndTime(Long setOfBooksId, String zonedDateTimeToString) {
        return periodClient.getPeriodBysetOfBooksIdAndDateTime(setOfBooksId, zonedDateTimeToString);
    }

    public List<CompanyCO> listCompaniesByIds(ArrayList<Long> ids) {
        return companyClient.listByIds(ids);
    }

    public List<DepartmentCO> listDepartmentsByIds(List<Long> ids) {
        return departmentClient.listDepartmentsByIds(ids);
    }

    public List<ContactCO> listUsersByIds(List<Long> ids) {
        return userClient.listByUserIds(ids);
    }

    public CompanyCO getCompanyById(Long companyId) {
        return companyClient.getById(companyId);
    }

    public String getOrderNumber(String documentType, String companyCode, String now) {
        return organizationClient.getOrderNumber(documentType, companyCode, now);
    }

    public List<UserGroupCO> listUserGroupsByIds(List<Long> ids) {
        return userClient.listUserGroupByUserGroupIds(ids);
    }


    public List<DimensionCO> listDimensionsByIds(List<Long> ids) {
        List<DimensionCO> dimensionCOS = dimensionClient.listDimensionsByIds(ids);
        if (CollectionUtils.isEmpty(dimensionCOS)) {
            return new ArrayList<>();
        }
        return dimensionCOS;
    }

    public List<DimensionDetailCO> listDimensionDetailsByIds(List<Long> ids, Boolean enabled) {
        List<DimensionDetailCO> dimensionDetailCOS = dimensionClient.listDimensionsByIdsAndEnabled(ids, enabled);
        if (CollectionUtils.isEmpty(dimensionDetailCOS)) {
            return new ArrayList<>();
        }
        return dimensionDetailCOS;
    }

    public List<DimensionItemCO> listDimensionItemsByIds(List<Long> ids) {
        List<DimensionItemCO> dimensionItemCOS = dimensionClient.listDimensionItemsByIds(ids);
        if (CollectionUtils.isEmpty(dimensionItemCOS)) {
            return new ArrayList<>();
        }
        return dimensionItemCOS;
    }

    public List<DimensionCO> listAllDimensionsBySetOfBooksId(Long setOfBooksId) {
        return dimensionClient.listDimensionBySetOfBooksIdAndEnabled(setOfBooksId, true);
    }

    public List<DimensionDetailCO> listDimensionsBySetOfBooksIdAndIds(Long setOfBooksId, List<Long> ids) {
        return dimensionClient.listDimensionsBySetOfBooksIdAndIdsAndEnabled(setOfBooksId, ids, null);
    }

    public ApprovalFormCO getApprovalFormByOid(String formOid) {
        return workflowClient.getApprovalFormByOid(formOid);
    }

    public List<DimensionCO> listDimensionsByCompanyId(Long companyId) {
        return dimensionClient.listDimensionsByCompanyId(companyId);
    }

    /**
     * 根据币种代码查询币种信息
     *
     * @param code
     * @param enabled
     * @param setOfBooksId
     * @return
     */
    public List<CurrencyRateCO> listCurrencysByCode(
            String code,
            Boolean enabled,
            Long setOfBooksId
    ) {
        return currencyClient.listCurrencysByCode(code, enabled, setOfBooksId);
    }


    public List<DimensionCO> listDimensionsBySetOfBooksIdConditionByIgnoreIds(Long setOfBooksId, String dimensionCode, String dimensionName, Boolean enabled, List<Long> ignoreIds) {
        return dimensionClient.listDimensionsBySetOfBooksIdConditionByIgnoreIds(setOfBooksId, dimensionCode, dimensionName, enabled, ignoreIds);
    }

    /**
     * 根据系统代码的code,以及值的code获取具体的系统代码
     *
     * @param code
     * @param value
     * @return
     */
    public SysCodeValueCO getSysCodeValueByCodeAndValue(String code, String value) {
        return organizationClient.getSysCodeValueByCodeAndValue(code, value);
    }

    public List<SysCodeValueCO> listSysCodeValueCOByOid(UUID codeOid) {
        return organizationClient.listEnabledSysCodeValueByCodeOid(codeOid);
    }

    /**
     * 根据用户id查询其组织架构Id信息
     *
     * @param userId
     * @return
     */
    public OrganizationUserCO getOrganizationCOByUserId(Long userId) {
        return userClient.getOrganizationCOByUserId(userId);
    }

    /**
     * 根据部门ID查询用户信息
     *
     * @param departmentId
     * @return
     */
    public List<ContactCO> listUsersByDepartmentId(Long departmentId) {
        return userClient.listUsersByDepartmentId(departmentId);
    }

    /**
     * 根据人员组ID查询用户信息
     *
     * @param userGroupId
     * @return
     */
    public List<ContactCO> listUsersByUserGroupId(Long userGroupId) {
        return userClient.listByUserGroupId(userGroupId);
    }

    /**
     * 查询当前租户下的所有员工
     *
     * @param tenantId
     * @return
     */
    public List<ContactCO> listUserByTenantId(Long tenantId) {
        return userClient.listUserByTenantId(tenantId);
    }

    /**
     * 获取值列表的所有值
     *
     * @param code
     * @return
     */
    public List<SysCodeValueCO> listAllSysCodeValueByCode(String code) {

        return organizationClient.listAllSysCodeValueByCode(code);
    }

    /**
     * 获取值列表启用的值
     *
     * @param code
     * @return
     */
    public List<SysCodeValueCO> listEnabledSysCodeValueByCode(String code) {

        return organizationClient.listEnabledSysCodeValueByCode(code);
    }

    /**
     * 提交工作流
     */
    public String submitWorkflow(WorkFlowDocumentRefCO workFlowDocumentRefCO) {
        return workflowClient.submitWorkflow(workFlowDocumentRefCO);
    }

    /**
     * 提交工作流
     */
    public ApprovalResultCO submitWorkflow(ApprovalDocumentCO approvalDocumentCO) {
        return workflowClient.submitWorkflow(approvalDocumentCO);
    }


    /**
     * 提交工作流
     */
    public void createApprovalErrorData(ApprovalErrorDataCO approvalErrorDataCO) {
        workflowClient.createApprovalErrorData(approvalErrorDataCO);
    }

    /**
     * 获取地区信息
     *
     * @param code
     * @return
     * @throws Exception
     */
    public LocationDTO getLocationByCode(String vendorType, String code) throws Exception {
        return locationInterface.getLocationByCode(vendorType, code);
    }

    /**
     * 更具科目代码获取科目描述
     * @param code
     * @return
     */
    public AccountsCO getByCode(String code) {
        return accountClient.getByCode(code);
    }

    /**
     * 根据公司代码获取公司名称
     * @param companyCode
     * @return
     */
    public CompanyCO getByCompanyCode(String companyCode){
        return companyClient.getByCompanyCode(companyCode);
    }

    /**
     * 根据公司代码获取子公司Id
     * @param companyCode
     * @return set
     */

    public Set<Long> listChildrenCompanyIdsByCompanyCode(String companyCode){
        return companyClient.listChildrenCompanyIdsByCompanyId(this.getByCompanyCode(companyCode).getId());
    }

    /**
     * 根据公司Id获取子公司Id
     * @param companyId
     * @return set
     */

    public Set<Long> listChildrenCompanyIdsByCompanyId(Long companyId){
        return companyClient.listChildrenCompanyIdsByCompanyId(companyId);
    }


    /**
     *
     *根据账套Id和公司Code批量获取公司数据
     * @param setOfBooksId
     * @param companyCodes
     * @return list
     */
    public List<CompanyCO> listBySetOfBooksIdAndCompanyCodes(Long setOfBooksId, List<String> companyCodes) {
        return companyClient.listBySetOfBooksIdAndCompanyCodes(setOfBooksId,companyCodes);
    }

    /**
     * 资金支付结果回写到费控detail表接口
     */
    public Boolean updateCashTransactionDetailByFund(List<CashTransactionDetailCO> cos){
        return paymentClient.updateCashTransactionDetailByFund(cos);
    }

    /**
     * 付款用途描述字段获取（根据code从费控接口获取）
     */
    public CashFlowItemCO getPaymentPurposeDesc(String code){
        return paymentClient.getCashFlowItemByCode(code);
    }

    /**
     * 根据code获取现金流量项
     * @param code
     * @return
     */
    public CashFlowItemCO getCashFlowItemByCode(String code) {
        return paymentClient.getCashFlowItemByCode(code);
    }

    /**
     * 根据部门id集合查询详情
     *
     * @param departmentIds 部门id集合
     * @return
     */
    public List<DepartmentCO> listPathByIds(List<Long> departmentIds) {
        return departmentClient.listPathByIds(departmentIds);
    }

    /**
     * 根据人员组id集合查询人员组信息及其固定分配的人员id
     *
     * @param ids
     * @return
     */
    public List<UserGroupCO> listUserGroupAndUserIdByGroupIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        return userClient.listUserGroupAndUserIdByGroupIds(ids);
    }

    /**
     * 根据ID集合查询公司信息
     *
     * @param companyIds 公司Id集合
     * @return 公司对象集合
     */
    public List<CompanyCO> listByIds(List<Long> companyIds) {
        if (CollectionUtils.isEmpty(companyIds)) {
            return new ArrayList<>();
        }
        return companyClient.listByIds(companyIds);
    }

    /**
     * 分页条件查询当前账套下的公司，排除指定的机构
     *
     * @param setOfBooksId     账套Id
     * @param companyCode      公司代码 条件查询
     * @param companyCodeFrom  公司代码从 条件查询
     * @param companyCodeTo    公司代码至 条件查询
     * @param companyName      公司名称
     * @param page             分页对象
     * @param ignoreCompanyIds 需要排除的公司Id集合 条件查询
     * @return 公司分页对象
     */
    public Page<CompanyCO> pageBySetOfBooksIdConditionByIgnoreIds(Long setOfBooksId,
                                                                  String companyCode,
                                                                  String companyCodeFrom,
                                                                  String companyCodeTo,
                                                                  String companyName,
                                                                  Page page,
                                                                  List<Long> ignoreCompanyIds) {
        return companyClient.pageBySetOfBooksIdConditionByIgnoreIds(setOfBooksId, companyCode, companyCodeFrom, companyCodeTo, companyName, true, page, ignoreCompanyIds);
    }

    /**
     * 根据员工oid查找部门
     *
     * @param empOid 员工oid
     * @return
     */
    public DepartmentCO getDepartmentByEmpOid(String empOid) {
        return departmentClient.getDepartmentByEmpOid(empOid);
    }


    /**
     * 获得全部国家<code,name>
     * @return
     */
    public Map<String,String> getCountry(){
        StringBuilder name = new StringBuilder();
        ResponseEntity<List<LocalizationDTO>> entity = localizationInterface.getLocalizationCountryByCode(null,null,0,1000);
        List<LocalizationDTO> dtoList = entity.getBody();
        Map<String,String> countryMap = new HashMap<>();
        dtoList.stream().forEach(s->{
            countryMap.put(s.getCode(),s.getCountry());
        });
        return countryMap;
    }

    /**
     * 根据code集合获取银行信息<code,bank>
     * @param bankCodeList
     * @return
     */
    public Map<String, BankInfoDTO> getBankDataByNumList(List<String> bankCodeList){
        Map<String,BankInfoDTO> out = new HashMap<>();
        List<BankInfoDTO> bankDataByNumList = bankInterface.getBankDataByNumList(bankCodeList);
        bankDataByNumList.stream().forEach(b->{
            out.put(b.getBankCode(),b);
        });
        return out;
    }

    /**
     * 获取未分配现金流量项
     * @param setOfBookId
     * @param flowCode
     * @param description
     * @param enabled
     * @param existIdList
     * @param page
     */
    public Page<CashFlowItemCO> getUndistributedCashFlowItemByCond(Long setOfBookId,
                                                                   String flowCode,
                                                                   String description,
                                                                   Boolean enabled,
                                                                   List<Long> existIdList,
                                                                   Page page) {
        return paymentClient.getUndistributedCashFlowItemByCond(setOfBookId, flowCode, description, enabled, existIdList, page);
    }

}
