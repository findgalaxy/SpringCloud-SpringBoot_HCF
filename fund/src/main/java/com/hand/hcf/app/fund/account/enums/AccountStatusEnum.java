package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @Author: liqiu.ruan@hand-china.com
 * @Date: 2019/2/27 16:14
 * @Description:账户状态
 */
public enum AccountStatusEnum implements IEnum {
    ZJ_ADDITIONAL(1001, "新增"),

    ZJ_CLOSED(1002, "销户"),

    ZJ_FROZEN(1003, "冻结"),

    ZJ_NORMAL(1004, "正常"),

    ZJ_REFUSED(1005, "拒绝");
    private Integer id;
    private String desc;

    AccountStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    @Override
    public Serializable getValue() {
        return this.id;
    }
}
