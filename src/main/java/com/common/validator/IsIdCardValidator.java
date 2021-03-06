package com.common.validator;

import com.common.commonUtils.StringUtils;
import com.common.commonUtils.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsIdCardValidator implements ConstraintValidator<IsIdCard, String> {

    private boolean required = false;

    @Override
    public void initialize(IsIdCard isIdCard) {
        required = isIdCard.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required) {
            return ValidatorUtil.isIdCard(value);
        } else {
            if(StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtil.isIdCard(value);
            }
        }
    }
}
