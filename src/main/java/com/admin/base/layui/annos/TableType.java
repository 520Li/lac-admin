package com.admin.base.layui.annos;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包含列头和列尾工具栏
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableType {

    /**
     * 数据表格第一列属性
     */
    String type() default "numbers";

    /**
     * 是否启用列尾工具栏
     */
    boolean toolbar() default false;

    /**
     * 数据表格尾部工具栏id（多个table需要指定不同的id）
     */
    String toolbarId() default "barId";

    /**
     * 数据表格尾部工具栏title
     *
     * @return
     */
    String title() default "操作";

    /**
     * 数据表格尾部工具栏位置
     *
     * @return
     */
    String align() default "center";

}
