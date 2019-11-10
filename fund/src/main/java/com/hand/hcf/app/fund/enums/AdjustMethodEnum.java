package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/4/8
 */
public enum AdjustMethodEnum implements IEnum {
    ALLOCATION(1001, "资金上划"),
    APPROPRIATE(1002, "资金下拨"),
    LEVEL(1003, "平级划转");

    private Integer id;
    private String desc;


    AdjustMethodEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
