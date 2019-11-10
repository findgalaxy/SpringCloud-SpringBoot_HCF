package com.hand.hcf.app.fund.account.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.hand.hcf.app.fund.account.enums.*;
import com.hand.hcf.app.fund.enums.BillStatusEnum;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/26 16:59
 * @Description:
 */
@TableName(value = "am_account_info")
@Data
@ApiModel(description = "账户信息表")
@NoArgsConstructor
@AllArgsConstructor
public class AccountInformation extends Domain {

    @ApiModelProperty(value = "单据OID")
    @TableField(value = "document_oid")
    private UUID documentOid;

    @ApiModelProperty(value = "开户维护单据OID")
    @TableField(value = "maintain_document_oid")
    private UUID maintainDocumentOid;

    @ApiModelProperty(value = "部门OID")
    @TableField(value = "department_oid")
    private UUID departmentOid;

    @ApiModelProperty(value = "单据编号")
    @TableField(value = "document_number")
    private String documentNumber;

    @ApiModelProperty(value = "单据类型")
    @TableField(value = "document_type")
    private Long documentType;

    @ApiModelProperty(value = "申请日期")
    @TableField(value = "requisition_date")
    private ZonedDateTime requisitionDate;

    @ApiModelProperty(value = "申请人ID")
    @TableField(value = "employee_id")
    private Long employeeId;

    @ApiModelProperty(value = "币种")
    @TableField(value = "currency_code")
    private String currencyCode;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "账户状态")
    @TableField(value = "status")
    private AccountStatusEnum status;

    @ApiModelProperty(value = "审批状态")
    @TableField(value = "approve_status")
    private BillStatusEnum approveStatus;

    @ApiModelProperty(value = "公司ID")
    @TableField(value = "company_id")
    private Long companyId;

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;

    @ApiModelProperty(value = "部门ID")
    @TableField(value = "department_id")
    private Long departmentId;

    @ApiModelProperty(value = "开户省份")
    @TableField(value = "open_province")
    private String openProvince;

    @ApiModelProperty(value = "开户城市")
    @TableField(value = "open_city")
    private String openCity;

    @ApiModelProperty(value = "开户银行")
    @TableField(value = "open_bank")
    private String openBank;

    @ApiModelProperty(value = "开户联行号")
    @TableField(value = "branch_bank")
    private String branchBank;

    @ApiModelProperty(value = "账户性质")
    @TableField(value = "account_property")
    private AccountPorpertyEnum accountProperty;

    @ApiModelProperty(value = "直连标志")
    @TableField(value = "direct_flag")
    private Boolean directFlag;

    @ApiModelProperty(value = "网银ukey")
    @TableField(value = "ukey_flag")
    private Boolean ukeyFlag;

    @ApiModelProperty(value = "定期账户提醒标志")
    @TableField(value = "regular_account_flag")
    private Boolean regularAccountFlag;

    @ApiModelProperty(value = "账户用途")
    @TableField(value = "account_use")
    private AccountUseEnum accountUse;

    @ApiModelProperty(value = "户名")
    @TableField(value = "account_name")
    private String accountName;

    @ApiModelProperty(value = "账号")
    @TableField(value = "account_number")
    private String accountNumber;

    @ApiModelProperty(value = "账户存款类型")
    @TableField(value = "account_deposit_type")
    private AccountDepositTypeEnum accountDepositType;

    @ApiModelProperty(value = "预留印鉴")
    @TableField(value = "fin_official_prime",strategy = FieldStrategy.IGNORED)
    private String finOfficialPrime;

    @ApiModelProperty(value = "开户日期")
    @TableField(value = "open_date")
    private ZonedDateTime openDate;

    @ApiModelProperty(value = "计息规则id")
    @TableField(value = "interest_rule_type",strategy = FieldStrategy.IGNORED)
    private Long interestRuleType;

    @ApiModelProperty(value = "银行地址")
    @TableField(value = "bank_address",strategy = FieldStrategy.IGNORED)
    private String bankAddress;

    @TableField(value = "customer_manager",strategy = FieldStrategy.IGNORED)
    private String customerManager;

    @ApiModelProperty(value = "联系电话")
    @TableField(value = "phone",strategy = FieldStrategy.IGNORED)
    private String phone;

    @ApiModelProperty(value = "核算科目")
    @TableField(value = "account_subjects_code")
    private String accountSubjectsCode;

    @ApiModelProperty(value = "明细段")
    @TableField(value = "detail_segment_code")
    private String detailSegmentCode;

    @ApiModelProperty(value = "明细段说明")
    @TableField(value = "detail_segment_code_desc")
    private String detailSegmentCodeDesc;

    @ApiModelProperty(value = "存款期限")
    @TableField(value = "deposit_term",strategy = FieldStrategy.IGNORED)
    private DepositTermEnum depositTerm;

    @ApiModelProperty(value = "到期提醒日期")
    @TableField(value = "reminder_date",strategy = FieldStrategy.IGNORED)
    private ZonedDateTime reminderDate;

    @ApiModelProperty(value = "关联附件的OID")
    @TableField(value = "attachment_oid",strategy = FieldStrategy.IGNORED)
    private String attachmentOid;

    @ApiModelProperty(value = "分支行信息")
    @TableField(value = "branch_bank_name")
    private String branchBankName;

    @ApiModelProperty(value = "开户维护单据编号")
    @TableField(value = "maintain_document_number")
    private String maintainDocumentNumber;

    @ApiModelProperty(value = "开户维护审批状态")
    @TableField(value = "maintain_approve_status")
    private BillStatusEnum maintainApproveStatus;

    @ApiModelProperty(value = "是否直接新增")
    @TableField(value = "direct_add_flag")
    private Boolean directAddFlag;

    @ApiModelProperty(value = "工资协议编号")
    @TableField(value = "wage_agreement_number",strategy=FieldStrategy.IGNORED)
    private String wageAgreementNumber;

    @ApiModelProperty(value = "工资标志")
    @TableField(value = "wage_flag")
    private Boolean wageFlag;


}
