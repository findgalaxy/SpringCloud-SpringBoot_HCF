package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 系统来源
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum SourceSystemEnum implements IEnum {

    CORE(1001, "核心系统"),
    HEC(1002, "费控系统");


    private Integer id;
    private String desc;

    SourceSystemEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    public static SourceSystemEnum getType(String key) {
        SourceSystemEnum[] its = SourceSystemEnum.values();
        for (SourceSystemEnum it : its) {
            if (it.getValue().equals(key)) {
                return it;
            }
        }
        return CORE;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }
}
