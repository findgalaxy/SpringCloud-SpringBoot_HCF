package com.hand.hcf.app.fund.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: lujia.xie@hand-china.com
 * @date: 2019/5/7 10:59
 */
public enum CalendarTypeEnum implements IEnum {
    HOLIDAY(1001, "节假日"),
    WORKING_DAY(1002, "工作日");

    private Integer id;
    private String desc;

    CalendarTypeEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    public static BillStatusEnum parse(Integer id) {
        for (BillStatusEnum fieldType : BillStatusEnum.values()) {
            if (fieldType.getValue().equals(id)) {
                return fieldType;
            }
        }
        return null;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }
}
