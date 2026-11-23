package io.github.parkwoong.example.util.validation.common;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class AbstractLongValidator<A extends Annotation>
        implements ConstraintValidator<A, Long> {

    private static final String blankErrorMessage = "must not be blank";

    // lang3 StringUtils.isBlank
    protected static boolean isBlank(final CharSequence cs) {

        final int length = cs == null ? 0 : cs.length();

        if (length == 0) return true;

        for (int i = 0; i < length; i++) if (!Character.isWhitespace(cs.charAt(i))) return false;

        return true;
    }

    protected static void changeMessage(ConstraintValidatorContext context, String message) {

        if (context == null || message == null) return;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

    protected static void blankErrorMessage(ConstraintValidatorContext context) {

        changeMessage(context, blankErrorMessage);
    }
}
