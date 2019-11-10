package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description: 支付状态
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/12
 */
public enum GatherStatusEnum implements IEnum {

    UNCOLLECTED(1001, "未收款"),
    COLLECTING(1002, "收款中"),
    FAILURE(1003, "收款失败"),
    SUCCESS(1004, "收款成功");


    private Integer id;
    private String desc;

    GatherStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    @Override
    public Serializable getValue() {
        return this.id;
    }

}
