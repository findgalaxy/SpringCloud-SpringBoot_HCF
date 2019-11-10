package com.hand.hcf.app.fund.account.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/3/4
 */
@TableName(value = "am_account_right_line_info")
@Data
@ApiModel(description = "账号权限管理行分配表")
public class AccountRightLine extends Domain {

    @ApiModelProperty(value = "基础表id")
    @TableField(value="base_id")
    private Long baseId;

    @ApiModelProperty(value = "账户id")
    @TableField(value="account_id")
    private Long accountId;

    @ApiModelProperty(value = "查询权限")
    @TableField(value = "query_flag")
    private Boolean queryFlag;

    @ApiModelProperty(value = "收款权限")
    @TableField(value = "gather_flag")
    private Boolean gatherFlag;

    @ApiModelProperty(value = "付款权限")
    @TableField(value = "pay_flag")
    private Boolean payFlag;

    @ApiModelProperty(value = "对账权限")
    @TableField(value = "check_flag")
    private Boolean checkFlag;

}
