package com.hand.hcf.app.fund.enums;

/**
 * @description:
 * @version: 1.0
 * @author: lujia.xie@hand-china.com
 * @date: 2019/4/15 10:07
 */
public enum AssignUserEnum {
    USER_ALL("BASIS_01", "全部人员") ,
    USER_DEPARTMENT("BASIS_02", "按部门分配"),
    USER_GROUP("BASIS_03", "按人员组");


    /**
     * 主键
     */
    private final String key;

    /**
     * 描述
     */
    private final String desc;

    AssignUserEnum(final String key, final String desc) {
        this.key = key;
        this.desc = desc;
    }


    public static AssignUserEnum getType(String key) {
        AssignUserEnum[] its = AssignUserEnum.values();
        for (AssignUserEnum it : its) {
            if (it.getKey().equals(key)) {
                return it;
            }
        }
        return USER_ALL;
    }

    public String getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }
}
