package com.admin.base.annotation;

import java.lang.annotation.*;

/**
 * ClassName: Field <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/3 0003 - 23:57
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    String field() default "";
    String title() default "";
}
