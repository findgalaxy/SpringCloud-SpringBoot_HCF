package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: lujia.xie@hand-china.com
 * @date: 2019/6/10 13:57
 */
public enum InvestmentFrequencyEnum implements IEnum {
    MONTH(1001, "月日"),
    QUARTER(1002, "季度日"),
    REPAY_OUTRIGHT(1003, "一次性");

    private Integer id;
    private String desc;


    InvestmentFrequencyEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
