package com.hand.hcf.app.fund.account.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/3/6
 */
@Data
@ApiModel(description = "账户余额表")
@TableName(value = "am_account_balance")
public class AccountBalance extends Domain {

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;

    @ApiModelProperty(value = "账户ID")
    @TableField(value = "account_id")
    private Long accountId;

    @ApiModelProperty(value = "账户余额")
    @TableField(value = "balance_amount")
    private BigDecimal balanceAmount;
}
