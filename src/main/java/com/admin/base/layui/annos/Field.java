package com.admin.base.layui.annos;

import com.admin.base.layui.enums.FieldType;

import java.lang.annotation.*;

/**
 * 用于标注数据表格@Column
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/3 0003 - 23:57
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    /**
     * column名称
     *
     * @return
     */
    String value();

    /**
     * 是否在数据表格显示
     *
     * @return
     */
    @Deprecated
    boolean display() default true;

    /**
     * column类型 （默认普通文本）
     *
     * @return
     */
    FieldType type() default FieldType.TEXT;
}
