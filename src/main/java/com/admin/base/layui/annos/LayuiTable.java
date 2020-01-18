package com.admin.base.layui.annos;

import java.lang.annotation.*;

/**
 * 用于标注实体类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LayuiTable {
    /**
     * 数据表格id (多个表格需要指定不同的id)
     */
    String elem();

    /**
     * 数据表格请求后台数据url(通用url)
     */
    String url() default "system/common/list";

    /**
     * 是否开启分页
     */
    boolean page() default true;

    /**
     * 列头 和 列尾工具栏
     */
    TableType value() default @TableType;

}
