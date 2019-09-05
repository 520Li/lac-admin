package com.admin.base.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableType {

    /**
     * 数据表格第一列属性
     */
    String type() default "numbers";

    /**
     * 数据表格尾部工具栏id
     * @return
     */
    String toolbar() default "common-toolbar";

    /**
     * 数据表格尾部工具栏title
     * @return
     */
    String title() default "操作";

    /**
     * 数据表格尾部工具栏位置
     * @return
     */
    String align() default "center";

}
