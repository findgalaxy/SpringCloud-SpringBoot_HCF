
package com.hand.hcf.app.fund.enums;


import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:单据审批状态 值列表和工作流返回相同
 */
public enum BillStatusEnum implements IEnum {
    ZJ_ADD(1001, "新建"),

    ZJ_APPROVED(1004, "已审批"),

    ZJ_REFUSE(1005, "拒绝"),

    ZJ_RESUME(1003, "收回"),

    ZJ_SUBMIT(1002, "审批中");

    private Integer id;
    private String desc;

    BillStatusEnum(Integer id, String desc) {
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
