package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 关闭状态
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/4/15
 */
public enum  ClosingStatusEnum implements IEnum {
    NORMAL(1001,"正常"),
    CLOSED(1002,"已关闭");


    private Integer id;
    private String desc;

    ClosingStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
