package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/13
 */
public enum PropFlagEnum implements IEnum {

    BOTH(1001, "对公-对私"),
    BUSINESS(1002, "对公"),
    PRIVATE(1003, "对私");


    private Integer id;
    private String desc;

    PropFlagEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
