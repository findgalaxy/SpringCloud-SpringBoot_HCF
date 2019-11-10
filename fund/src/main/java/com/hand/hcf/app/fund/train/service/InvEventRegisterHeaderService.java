package com.hand.hcf.app.fund.train.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hand.hcf.app.fund.externalApi.OrganizationService;
import com.hand.hcf.app.fund.train.domain.InvEventRegisterHeader;
import com.hand.hcf.app.fund.train.domain.InvTypeMaintain;
import com.hand.hcf.app.fund.train.dto.InvEventRegisterHeaderDTO;
import com.hand.hcf.app.fund.train.persistence.InvEventRegisterHeaderMapper;
import com.hand.hcf.app.mdata.client.com.CompanyCO;
import com.hand.hcf.app.mdata.client.com.CompanyClient;
import com.hand.hcf.app.mdata.client.contact.ContactCO;
import com.hand.hcf.app.mdata.client.contact.ContactClient;
import com.hand.hcf.app.mdata.client.sob.SetOfBooksInfoCO;
import com.hand.hcf.core.service.BaseService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Service
public class InvEventRegisterHeaderService extends BaseService<InvEventRegisterHeaderMapper, InvEventRegisterHeader> {


    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CompanyClient  companyClient;

    @Autowired
    private ContactClient contactClient;

    @Autowired
    private InvEventRegisterHeaderMapper invEventRegisterHeaderMapper;

    @Autowired
    private InvEventRegisterLineService invEventRegisterLineService;

    @Autowired
    private InvTypeMaintainService invTypeMaintainService;

    /**
     * 分页查询条件说明
     * @param setOfBooksId 账套ID 01
     * @param invNumber 投资编号 02
     * @param invTypeId 投资类型ID 03
     * @param invProductName 投资产品名称 04
     * @param equityCompanyId 权益公司ID 05
     * @param amountFrom 金额从 06
     * @param amountTo 金额至 07
     * @param billStatus 单据状态 08
     * @param mybatisPage 分页
     * @return
     */
    public List<InvEventRegisterHeaderDTO> pageInvEventRegisterHeaderByCond(Long setOfBooksId, String invNumber, Long invTypeId,
                                                                            String invProductName, Long equityCompanyId,
                                                                            BigDecimal amountFrom, BigDecimal amountTo,
                                                                            Integer billStatus, Page mybatisPage) {

        List<InvEventRegisterHeader> invEventRegisterHeaderList = baseMapper.selectPage(mybatisPage,new EntityWrapper<InvEventRegisterHeader>()
                .eq(setOfBooksId != null,"set_of_books_id",setOfBooksId)
                .like(invNumber != null && !invNumber.equals(""), "inv_number",invNumber)
                .eq(invTypeId != null,"inv_type_id",invTypeId)
                .like(invProductName != null &&!invProductName.equals(""),"inv_product_name",invProductName)
                .eq(equityCompanyId != null,"equity_company_id",equityCompanyId)
                .gt(amountFrom != null,"amount",amountFrom) //gt(大于 >)
                .lt(amountTo != null,"amount",amountTo)//lt(小于 <) le(小于等于 <=)
                .eq(billStatus != null,"bill_status",billStatus)
        );


        List<InvEventRegisterHeaderDTO> listDTO = new ArrayList<>();
        for(InvEventRegisterHeader invEventRegisterHeader : invEventRegisterHeaderList) {
            InvEventRegisterHeaderDTO invEventRegisterHeaderDTO= this.toDTO(invEventRegisterHeader);
            listDTO.add(invEventRegisterHeaderDTO);
        }

        return listDTO;
    }


    /**
     * 将invEventRegisterHeader对象转化成前端所需要的DTO
     * @param invEventRegisterHeader
     * @return
     */
    public InvEventRegisterHeaderDTO toDTO(InvEventRegisterHeader invEventRegisterHeader) {
        InvEventRegisterHeaderDTO dto = mapperFacade.map(invEventRegisterHeader,InvEventRegisterHeaderDTO.class);
        /**
         * 通过账套ID来获取账套名称
         * 账套id：1083762150064451585
         * 公司id：1083751704185716737
         */
        SetOfBooksInfoCO setOfBooksInfoCO = organizationService.getSetOfBooksInfoCOById(1083762150064451585L, false);
        dto.setSetOfBooksName(setOfBooksInfoCO.getSetOfBooksName());
        /**
         * 通过投资类型ID来获取投资类型名称
         */
        InvTypeMaintain invTypeMaintain = invTypeMaintainService.selectById(invEventRegisterHeader.getInvTypeId());
        dto.setInvTypeName(invTypeMaintain.getInvTypeName());



        /**
         * 通过权益公司Id获取权益公司名称
         */
        CompanyCO companyCO = companyClient.getById(1083751704185716737L);
        dto.setEquityCompanyName(companyCO.getName());

        /**
         * 通过管理员ID获取管理员名称
         */
        ContactCO contactCO = contactClient.getById(invEventRegisterHeader.getManagementId());
        dto.setManagementName(contactCO.getFullName());

        return dto;

    }

    /**
     * 查询投资编号是否为唯一
     * @param invNumber
     * @return
     */
    public boolean checkInvNumberIsUnique(String invNumber) {

        InvEventRegisterHeader invEventRegisterHeader = invEventRegisterHeaderMapper.selectByInvNumber(invNumber);
        if(invEventRegisterHeader == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加投资事件登记头
     * @param setOfBooksId
     * @param invNumber
     * @param invTypeID
     * @param invProductName
     * @param equityCompanyId
     * @param equityUnitId
     * @param otherCompany
     * @param managementId
     * @param maintenanceDate
     * @param invNote
     * @param attachmentInfo
     * @return
     */
    public String addInvEventRegisterHeader(Long setOfBooksId, String invNumber, Long invTypeID,
                                         String invProductName, Long equityCompanyId, Long equityUnitId,
                                         String otherCompany, Long managementId, Date maintenanceDate,
                                         String invNote, String attachmentInfo) {
        InvEventRegisterHeader invEventRegisterHeader = new InvEventRegisterHeader();
        invEventRegisterHeader.setSetOfBooksId(setOfBooksId);
        invEventRegisterHeader.setInvNumber(invNumber);
        invEventRegisterHeader.setInvTypeId(invTypeID);
        invEventRegisterHeader.setInvProductName(invProductName);
        invEventRegisterHeader.setEquityCompanyId(equityCompanyId);
        invEventRegisterHeader.setEquityUnitId(equityUnitId);
        invEventRegisterHeader.setOtherCompany(otherCompany);
        invEventRegisterHeader.setManagementId(managementId);
        invEventRegisterHeader.setMaintenanceDate(maintenanceDate);
        invEventRegisterHeader.setInvNote(invNote);
        invEventRegisterHeader.setAttachmentInfo(attachmentInfo);

        if(checkInvNumberIsUnique(invEventRegisterHeader.getInvNumber())) {
            baseMapper.insert(invEventRegisterHeader);
            return "成功!";
        } else {
            return "失败！";
        }
    }




    /**
     * 更新修改投资事件登记头
     * @param invEventRegisterHeader
     * @return
     */
    public boolean updateInvEventRegisterHeader(InvEventRegisterHeader invEventRegisterHeader) {
        if(invEventRegisterHeader == null) {
            return false;
        } else {
            if(invEventRegisterHeader.getId() != null) {
                return baseMapper.updateById(invEventRegisterHeader)>0;
            } else {
                return false;
            }
        }
    }


    /**
     * 根据头ID来删除头行
     * @param headerId
     * @return
     */
    public int deleteHeaderAndLine(Long headerId) {
        InvEventRegisterHeader invEventRegisterHeader = baseMapper.selectById(headerId);
        if(invEventRegisterHeader != null) {
             baseMapper.deleteById(headerId);
             invEventRegisterLineService.deleteAllLinesByHeaderId(headerId);
             return 1;
        } else {
            return 0;
        }
    }
}
