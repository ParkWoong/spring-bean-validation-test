package io.github.parkwoong.example.util.validation;

import io.github.parkwoong.example.util.validation.common.AbstractValidator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidatorContext;

public class EnumStringValidator extends AbstractValidator<EnumString> {

    private boolean notBlank;
    private Set<String> set = new HashSet<>();

    @Override
    public void initialize(EnumString constraintAnnotation) {

        notBlank = constraintAnnotation.notBlank();

        for (final String value : constraintAnnotation.values()) set.add(value);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {

        if (isBlank(field)) {

            blankErrorMessage(context);
            return !notBlank;
        }
        return set.contains(field);
    }
}
