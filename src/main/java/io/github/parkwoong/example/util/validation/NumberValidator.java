package io.github.parkwoong.example.util.validation;

import io.github.parkwoong.example.util.validation.common.AbstractLongValidator;

import java.util.Objects;

import javax.validation.ConstraintValidatorContext;

public class NumberValidator extends AbstractLongValidator<Number> {

    private String SIZE = "size must be ";

    private int minSize = -1;
    private int maxSize = -1;

    private boolean notBlank;

    @Override
    public void initialize(Number constraintAnnotation) {

        // size of byte
        minSize = constraintAnnotation.minSize();
        maxSize = constraintAnnotation.maxSize();

        SIZE += minSize == maxSize ? minSize : "between " + minSize + " and " + maxSize;

        notBlank = constraintAnnotation.notBlank();
    }

    @Override
    public boolean isValid(Long field, ConstraintValidatorContext context) {

        // data validation
        if (Objects.isNull(field)) {
            blankErrorMessage(context);
            return !notBlank;
        }
        ;

        final String value = String.valueOf(field);
        final int length = value == null ? 0 : value.length();

        if (field < 0 || length < minSize || maxSize < length) {
            changeMessage(context, SIZE);
            return false;
        }

        return true;
    }
}
