package com.admin.base.annotation;

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
     * @return
     */
    String title();
}
