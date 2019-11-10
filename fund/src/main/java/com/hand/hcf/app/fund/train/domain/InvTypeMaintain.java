package com.hand.hcf.app.fund.train.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */
@ApiModel(description = "投资类型维护表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inv_type_maintain")
public class InvTypeMaintain extends Domain {

    @ApiModelProperty(value = "投资类型维护表ID")
    private Long id;

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;

    @ApiModelProperty(value = "投资类型代码")
    @TableField(value = "inv_type_code")
    private String invTypeCode;

    @ApiModelProperty(value = "投资类型名称")
    @TableField(value = "inv_type_name")
    private String invTypeName;

    @ApiModelProperty(value = "启用状态")
    @TableField(value = "start_status")
    private Integer startStatus;
}
