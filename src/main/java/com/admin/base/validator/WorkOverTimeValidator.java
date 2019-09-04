package com.admin.base.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ClassName: WorkOverTimeValidator <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/25 0025 - 19:26
 */
public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {
    WorkOverTime work;
    int max;

    @Override
    public void initialize(WorkOverTime work) {
        this.work = work;
        this.max = work.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value < max;
    }
}
