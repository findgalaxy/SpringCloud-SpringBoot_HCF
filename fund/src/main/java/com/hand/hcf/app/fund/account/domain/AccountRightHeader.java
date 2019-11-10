package com.hand.hcf.app.fund.account.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.hand.hcf.app.fund.account.enums.UkeyTypeEnum;
import com.hand.hcf.core.domain.DomainEnable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/3/4
 */
@TableName(value = "am_account_right_base_info")
@Data
@ApiModel(description = "账号权限管理基础表")
public class AccountRightHeader extends DomainEnable {

    @ApiModelProperty(value = "员工id")
    @TableField(value = "employee_id")
    private Long employeeId;

    @ApiModelProperty(value = "默认支付验证类别")
    private UkeyTypeEnum defaultUkeyType;

    @ApiModelProperty(value = "ukey序列号")
    @TableField(value = "default_ukey_desc",strategy = FieldStrategy.IGNORED)
    private String defaultUkeyDesc;

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;


}
