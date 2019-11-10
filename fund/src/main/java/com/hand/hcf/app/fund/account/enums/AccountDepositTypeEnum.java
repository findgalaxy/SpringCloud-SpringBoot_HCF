package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:存款类型
 */
public enum AccountDepositTypeEnum implements IEnum {

    ZJ_AGREEMENT(1001, "协定存款"),

    ZJ_DEMAND(1002, "活期存款"),

    ZJ_TIME(1003, "定期存款");

    private Integer id;
    private String desc;


    AccountDepositTypeEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    @Override
    public Serializable getValue() {
        return this.id;
    }

}
