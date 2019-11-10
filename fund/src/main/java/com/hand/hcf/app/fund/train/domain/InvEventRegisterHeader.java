package com.hand.hcf.app.fund.train.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hand.hcf.core.domain.Domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@ApiModel(description = "投资事件登记头表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inv_event_register_header")
public class InvEventRegisterHeader extends Domain {

    @ApiModelProperty(value = "投资事件登记头表ID")
    private Long id;

    @ApiModelProperty(value = "账套ID")
    @TableField(value = "set_of_books_id")
    private Long setOfBooksId;

    @ApiModelProperty(value = "租户ID")
    @TableField(value = "tenant_id")
    private Long tenantId;

    @ApiModelProperty(value = "投资编号")
    @TableField(value = "inv_number")
    private String invNumber;

    @ApiModelProperty(value = "投资类型ID")
    @TableField(value = "inv_type_id")
    private Long invTypeId;

    @ApiModelProperty(value = "投资产品名称")
    @TableField(value = "inv_product_name")
    private String invProductName;

    @ApiModelProperty(value = "权益公司ID")
    @TableField(value = "equity_company_id")
    private Long equityCompanyId;

    @ApiModelProperty(value = "权益部门ID")
    @TableField(value = "equity_unit_id")
    private Long equityUnitId;

    @ApiModelProperty(value = "对方公司")
    @TableField(value = "other_company")
    private String otherCompany;

    @ApiModelProperty(value = "管理员ID")
    @TableField(value = "management_id")
    private Long managementId;

    @ApiModelProperty(value = "维护日期")
    @TableField(value = "maintenance_date")
    private Date maintenanceDate;

    @ApiModelProperty(value = "金额")
    @TableField(value = "amount")

    private BigDecimal amount;

    @ApiModelProperty(value = "投资备注")
    @TableField(value = "inv_note")
    private String invNote;

    @ApiModelProperty(value = "附件信息")
    @TableField(value = "attachment_info")
    private String attachmentInfo;

    @ApiModelProperty(value = "单据状态")
    @TableField(value = "bill_status")
    private Integer billStatus;

}
