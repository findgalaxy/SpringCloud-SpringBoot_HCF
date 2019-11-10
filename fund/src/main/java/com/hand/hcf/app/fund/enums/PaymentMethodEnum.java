package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 付款方式
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum PaymentMethodEnum implements IEnum {
    BANKBILL(1001, "汇票"),
    BTR(1002, "网银电汇"),
    CASH(1003, "现金"),
    CHECK(1004, "支票"),
    INTERFACE(1005, "银企直连"),
    RECORDING_PAYMENT(1006, "补录付款");


    private Integer id;
    private String desc;

    PaymentMethodEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
