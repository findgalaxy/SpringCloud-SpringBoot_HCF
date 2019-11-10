package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:账户性质
 */
public enum AccountPorpertyEnum implements IEnum {
    ZJ_BASIC(1001, "基本户"),

    ZJ_GENERAL(1002, "一般户"),

    ZJ_SPECIAL(1003, "专用户");
    private Integer id;
    private String desc;


    AccountPorpertyEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    @Override
    public Serializable getValue() {
        return this.id;
    }
}
