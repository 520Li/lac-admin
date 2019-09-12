package com.admin.base.annotation;

/**
 * 查询项类型
 */
public enum QueryType {
    //文本框
    INPUT,
    //下拉选择框
    SELECT,
    //按钮
    CHECKBOX,
    //树
    TREE,
    //日期时间
    DATETIME,
    //日期
    DATE,
    //年份
    DATEYY,
    //月份
    DATEMM,
    //开始时间
    BEGIN,
    //结束时间
    END;

    QueryType() {

    }

}