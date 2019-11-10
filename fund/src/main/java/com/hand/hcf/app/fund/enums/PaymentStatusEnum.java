package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 支付状态
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum PaymentStatusEnum implements IEnum {

    BEING(1001, "支付中"),
    FAILURE(1002, "支付失败"),
    REFUND(1003, "退票"),
    SUCCESS(1004, "支付成功"),
    UNPAID(1005, "未支付");

    private Integer id;
    private String desc;

    PaymentStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }

}
