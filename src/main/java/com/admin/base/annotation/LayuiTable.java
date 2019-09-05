package com.admin.base.annotation;

import java.lang.annotation.*;

/**
 * 用于标注实体类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LayuiTable {
    /**
     * 数据表格id (如果一个页面多个表格需要指定id)
     */
    String elem() default "common-table";

    /**
     * 数据表格请求后台数据url
     */
    String url();

    /**
     * 是否开启分页
     */
    boolean page() default true;

}
