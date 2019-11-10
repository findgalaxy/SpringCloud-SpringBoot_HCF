package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 预警状态
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum WarningStatusEnum implements IEnum {
    LOCKED(1001, "锁定"),
    PASS(1002, "通过"),
    REMOVED(1003, "已解除");

    private Integer id;
    private String desc;

    WarningStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }
}
