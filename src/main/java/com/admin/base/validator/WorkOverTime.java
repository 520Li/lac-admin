package com.admin.base.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义校验  加班时间校验 <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/25 0025 - 19:25
 */

@Constraint(validatedBy = WorkOverTimeValidator.class)
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {
    String message() default "加班时间不能超过{max}小时";

    int max() default 5;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
