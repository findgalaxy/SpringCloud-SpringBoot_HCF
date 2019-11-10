package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: lujia.xie@hand-china.com
 * @date: 2019/5/16 10:51
 */
public enum AutoGatherExecuteStatusEnum implements IEnum {
    NEW(1001, "新建"),
    RUNNING(1002, "执行中"),
    FINISH(1003, "执行完"),
    ERROR(1004, "执行出错");

    private Integer id;
    private String desc;


    AutoGatherExecuteStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }
}
