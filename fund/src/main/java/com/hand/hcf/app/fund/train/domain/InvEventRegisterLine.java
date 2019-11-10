package com.hand.hcf.app.fund.train.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BooleanSupplier;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@ApiModel(description = "投资事件登记行表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inv_event_register_line")
public class InvEventRegisterLine extends Domain {

    @ApiModelProperty(value = "投资事件登记行表ID")
    private Long id;

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;

    @ApiModelProperty(value = "投资事件头ID")
    @TableField(value = "inv_event_header_id")
    private Long invEventHeaderId;

    @ApiModelProperty(value = "开始时间")
    @TableField(value = "start_date")
    private Date startDate;

    @ApiModelProperty(value = "结束时间")
    @TableField(value = "end_date")
    private Date endDate;

    @ApiModelProperty(value = "投资金额")
    @TableField(value = "inv_amount")
    private BigDecimal invAmount;

    @ApiModelProperty(value = "投资币种")
    @TableField(value = "inv_currency_code")
    private String invCurrencyCode;

    @ApiModelProperty(value = "投资期限")
    @TableField(value = "inv_horizon")
    private Date invHorizon;

    @ApiModelProperty(value = "汇率")
    @TableField(value = "exchange_rate")
    private Double exchangeRate;

    @ApiModelProperty(value = "对方账号")
    @TableField(value = "reciprocal_account_number")
    private String reciprocalAccountNumber;

    @ApiModelProperty(value = "对方账户")
    @TableField(value = "reciprocal_account")
    private String reciprocalAccount;

    @ApiModelProperty(value = "对方银行联行号")
    @TableField(value = "reciprocal_bank_number")
    private Long reciprocalBankNumber;

    @ApiModelProperty(value = "收益率")
    @TableField(value = "yield_rate")
    private Double yieldRate;

    @ApiModelProperty(value = "结息频率")
    @TableField(value = "interest_settlement_frequency")
    private Integer interestSettlementFrequency;

    @ApiModelProperty(value = "结息日")
    @TableField(value = "interest_settlement_date")
    private Date interestSettlementDate;

    @ApiModelProperty(value = "期限范围")
    @TableField(value = "time_limit_range")
    private Date timeLimitRange;

    @ApiModelProperty(value = "计息规则")
    @TableField(value = "interest_accrual_rules")
    private String interestAccrualRules;

    @ApiModelProperty(value = "收款银行")
    @TableField(value = "due_bank")
    private String dueBank;

    @ApiModelProperty(value = "收款账号")
    @TableField(value = "due_account")
    private String dueAccount;

    @ApiModelProperty(value = "是否到期提醒")
    @TableField(value = "expiration_reminder")
    private Boolean expirationReminder;

    @ApiModelProperty(value = "是否收益提醒")
    @TableField(value = "earnings_reminder")
    private Boolean earningsReminder;

    @ApiModelProperty(value = "对方联系人")
    @TableField(value = "contact_person")
    private String contactPerson;

    @ApiModelProperty(value = "联系电话")
    @TableField(value = "contact_phone")
    private String contactPhone;

    @ApiModelProperty(value = "地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty(value = "合同编号")
    @TableField(value = "contract_number")
    private String contractNumber;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark_info")
    private String remarkInfo;
}
