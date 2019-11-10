package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:付款头中的处理状态
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/3/12
 */
public enum PaymentHandleStateEnum implements IEnum {
    PAYABLE(1001, "待支付"),
    RETURNED(1002, "已返回"),
    SEND(1003, "已发送"),
    RECEIVABLE(1004,"待收款");


    private Integer id;
    private String desc;

    PaymentHandleStateEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
