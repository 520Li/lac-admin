package com.admin.base.layui.enums;

/**
 * 查询条件类型
 */
public enum Method {
    // 等于
    EQUALS,
    // 模糊查询
    LIKE,
    // 区间
    BETWEEN,
    // 大于
    MORE,
    // 大等于
    MOREEQ,
    // 小于
    LESS,
    // 小等于
    LESSEQ,
    // 多选
    IN;

    Method() {

    }
}
