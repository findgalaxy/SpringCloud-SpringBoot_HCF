package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:存款类型
 */
public enum DepositTermEnum implements IEnum {

    FIVE_YEARS(1001, "五年"),

    QUARTER(1002, "三个月"),

    THREE_YEARS(1003, "三年"),

    YEAR(1004, "一年");

    private Integer id;
    private String desc;


    DepositTermEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }

}
