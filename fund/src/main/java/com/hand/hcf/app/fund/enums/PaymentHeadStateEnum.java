package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:付款头状态
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/3/12
 */
public enum PaymentHeadStateEnum implements IEnum {
    ALL_FAILURES(1001, "全部失败"),
    ALL_SUCCESSFUL(1002, "全部成功"),
    PART_SUCCESSFUL(1003, "部分成功"),
    TO_SEND(1004, "待发送"),
    TO_UPDATE(1005, "待更新");

    private Integer id;
    private String desc;

    PaymentHeadStateEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }
}
