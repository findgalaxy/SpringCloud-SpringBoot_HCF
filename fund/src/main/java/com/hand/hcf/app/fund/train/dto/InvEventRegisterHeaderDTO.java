package com.hand.hcf.app.fund.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvEventRegisterHeaderDTO {
    /**
     * 01投资编号
     */
    private String invNumber;
    /**
     * 02账套
     */
    private String setOfBooksName;
    /**
     * 03投资类型
     */
    private String invTypeName;
    /**
     * 04投资产品名称
     */
    private String invProductName;
    /**
     * 05权益公司
     */
    private String  equityCompanyName;
    /**
     * 06对方公司
     */
    private String otherCompany;
    /**
     * 07金额
     */
    private BigDecimal amount;
    /**
     * 08管理员
     */
    private String managementName;
    /**
     * 09状态
     */
    private Integer billStatus;
    /**
     * 10维护日期
     */
    private Date maintenanceDate;
}
