package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 收款方式
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/5/13
 */
public enum GatherMethodEnum implements IEnum {
    INTERFACE(1001, "银企直连"),
    OFFLINE(1002, "线下收款");


    private Integer id;
    private String desc;

    GatherMethodEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
