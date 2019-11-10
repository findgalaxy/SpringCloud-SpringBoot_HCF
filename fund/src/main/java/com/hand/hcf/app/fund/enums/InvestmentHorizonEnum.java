package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: lujia.xie@hand-china.com
 * @date: 2019/6/10 13:52
 */
public enum InvestmentHorizonEnum implements IEnum {
    ONE_MONTH(1001, "一个月"),
    ONE_QUARTER(1002, "三个月"),
    HALF_YEAT(1003, "六个月"),
    ONE_YEAR(1004, "一年"),
    TWO_YEAR(1005, "两年"),
    THREE_YEAR(1006, "三年"),
    FIVE_YEAR(1007, "五年");

    private Integer id;
    private String desc;


    InvestmentHorizonEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
