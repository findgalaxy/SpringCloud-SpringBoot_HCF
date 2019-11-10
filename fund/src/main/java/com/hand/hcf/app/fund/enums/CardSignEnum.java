package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 卡折标志
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum CardSignEnum implements IEnum {

    BANKBOOK(1001, "存折"),
    BANK_CARD(1002, "银行卡"),
    CREDIT_DARD(1003, "信用卡");

    private Integer id;
    private String desc;

    CardSignEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
