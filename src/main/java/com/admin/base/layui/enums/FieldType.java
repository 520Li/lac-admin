package com.admin.base.layui.enums;

/**
 * 数据表格column字段类型 <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/5 0005 - 22:38
 */
public enum FieldType {

    /**
     * 普通文本
     */
    TEXT,

    /**
     * 可编辑文本
     */
    EDIT_TEXT,

    /**
     * 下拉框
     */
    SELECT,

    /**
     * 开关
     */
    SWITCH;


    String ID = "common-state";

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    FieldType() {

    }
}
