package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:
 */
public enum AccountUseEnum implements IEnum {
    ZJ_BAIL_ACCOUNT(1001, "保证金户"),

    ZJ_EXPENSESZ_ACCOUNT(1002, "支出户"),

    ZJ_FINANCE_ACCOUNT(1003, "融资账户"),

    ZJ_INCOME_ACCOUNT(1004, "收入户"),

    ZJ_INVEST_ACCOUNT(1005, "投资户");
    private Integer id;
    private String desc;

    AccountUseEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    @Override
    public Serializable getValue() {
        return this.id;
    }
}
