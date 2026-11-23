package io.github.parkwoong.example.util.validation;

import io.github.parkwoong.example.util.validation.common.AbstractLongValidator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidatorContext;

public class EnumValidator extends AbstractLongValidator<Enum> {

    private boolean notBlank;
    private Set<Long> set = new HashSet<>();

    @Override
    public void initialize(Enum constraintAnnotation) {

        notBlank = constraintAnnotation.notBlank();

        for (final Long value : constraintAnnotation.values()) set.add(value);
    }

    @Override
    public boolean isValid(Long field, ConstraintValidatorContext context) {

        if (field == null) {

            blankErrorMessage(context);
            return !notBlank;
        }

        return set.contains(field);
    }
}
