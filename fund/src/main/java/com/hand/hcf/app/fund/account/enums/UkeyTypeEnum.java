package com.hand.hcf.app.fund.account.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @description:
 * @version: 1.0
 * @author: qinye.lin@hand-china.com
 * @date: 2019/3/4
 */
public enum UkeyTypeEnum implements IEnum {
    /**
     * 默认支付验证类别
     */
    UKEY(1001);

    private Integer id;

    UkeyTypeEnum(Integer id) {
        this.id = id;
    }

    @Override
    public Serializable getValue() {
        return this.id;
    }

    public static UkeyTypeEnum parse(Integer id) {
        for (UkeyTypeEnum type : UkeyTypeEnum.values()){
            if (type.getValue().equals(id)){
                return type;
            }
        }
        return null;
    }

}
