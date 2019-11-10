package com.hand.hcf.app.fund.enums;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/3/4 14:14
 * @Description: 工作流单据类型枚举类
 */

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

public enum DocumentTypeEnum implements IEnum {
    /* 单据类型枚举*/
    OPEN_ACCOUNT(901001, "OPEN_ACCOUNT", "开户申请"),
    OPEN_MAINTAIN(901002, "OPEN_MAINTAIN", "开户维护"),
    ACCOUNT_CHANGE(901003, "ACCOUNT_CHANGE", "开户变更"),
    MANUAL_PAYMENT(901004, "MANUAL_PAYMENT", "手工付款"),
    BATCH_PAYMENT(901005, "BATCH_PAYMENT", "批量付款"),
    ADJUST_APPLI(901006, "ADJUST_APPLI", "调拨申请单"),
    ADJUST(901007,"ADJUST","资金调拨单"),
    ADJUST_ADD(901008,"ADJUST_ADD","补录调拨单"),
    ADJUST_AUTO(901009,"ADJUST_AUTO","自动调拨单"),
    AUTO_PAYMENT(901010,"AUTO_PAYMENT","自动付款单"),
    WAGE_PAYMENT(901011,"WAGE_PAYMENT","工资付款单"),
    PAYMENT_ADD(901012,"PAYMENT_ADD","补录付款"),
    MANUAL_GATHER(901014,"MANUAL_GATHER","手工收款单"),
    BATCH_GATHER(901015,"BATCH_GATHER","批量收款单"),
    ADD_GATHER(901016,"ADD_GATHER","补录收款单");


    /**
     * 主键
     */
    private final Integer key;

    private final String category;
    /**
     * 描述
     */
    private final String desc;

    DocumentTypeEnum(final Integer key, final String category, final String desc) {
        this.key = key;
        this.desc = desc;
        this.category = category;
    }


    public static DocumentTypeEnum getType(Integer key) {
        DocumentTypeEnum[] its = DocumentTypeEnum.values();
        for (DocumentTypeEnum it : its) {
            if (it.getValue().equals(key)) {
                return it;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public Serializable getValue() {
        return this.key;
    }
}
