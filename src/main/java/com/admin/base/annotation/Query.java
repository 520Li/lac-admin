package com.admin.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注查询字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {
    /**
     * 条件查询名称
     *
     * @return
     */
    String name();

    /**
     * 条件查询类型  默认input框
     *
     * @return
     */
    QueryType type() default QueryType.INPUT;

    /**
     * 条件查询方式   默认 ==
     *
     * @return
     */
    Method method() default Method.EQUALS;


}
