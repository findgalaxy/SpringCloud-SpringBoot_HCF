package com.hand.hcf.app.fund.account.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/26 16:59
 * @Description:
 */
@TableName(value = "am_account_ukey_info")
@Data
@ApiModel(description = "账户ukey信息表")
@NoArgsConstructor
@AllArgsConstructor
public class AccountUkeyInformation extends Domain {

    @ApiModelProperty(value = "UKEY编号1")
    @TableField(value = "ukey1_num", strategy = FieldStrategy.IGNORED)
    private String ukey1Num;

    @ApiModelProperty(value = "UKEY编号2")
    @TableField(value = "ukey2_num", strategy = FieldStrategy.IGNORED)
    private String ukey2Num;

    @ApiModelProperty(value = "UKEY编号3")
    @TableField(value = "ukey3_num", strategy = FieldStrategy.IGNORED)
    private String ukey3Num;

    @ApiModelProperty(value = "登记员工1")
    @TableField(value = "ukey1_register_name", strategy = FieldStrategy.IGNORED)
    private String ukey1RegisterName;

    @ApiModelProperty(value = "登记员工2")
    @TableField(value = "ukey2_register_name", strategy = FieldStrategy.IGNORED)
    private String ukey2RegisterName;

    @ApiModelProperty(value = "登记员工3")
    @TableField(value = "ukey3_register_name", strategy = FieldStrategy.IGNORED)
    private String ukey3RegisterName;

    @ApiModelProperty(value = "使用员工1")
    @TableField(value = "ukey1_using_name", strategy = FieldStrategy.IGNORED)
    private String ukey1UsingName;

    @ApiModelProperty(value = "使用员工2")
    @TableField(value = "ukey2_using_name", strategy = FieldStrategy.IGNORED)
    private String ukey2UsingName;

    @ApiModelProperty(value = "使用员工3")
    @TableField(value = "ukey3_using_name", strategy = FieldStrategy.IGNORED)
    private String ukey3UsingName;

    @ApiModelProperty(value = "UKEY1到期日")
    @TableField(value = "ukey1_expiry_date", strategy = FieldStrategy.IGNORED)
    private ZonedDateTime ukey1ExpiryDate;

    @ApiModelProperty(value = "UKEY2到期日")
    @TableField(value = "ukey2_expiry_date", strategy = FieldStrategy.IGNORED)
    private ZonedDateTime ukey2ExpiryDate;

    @ApiModelProperty(value = "UKEY3到期日")
    @TableField(value = "ukey3_expiry_date", strategy = FieldStrategy.IGNORED)
    private ZonedDateTime ukey3ExpiryDate;

}
