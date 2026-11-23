package io.github.parkwoong.example.util.validation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {

    String message() default "must be a number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minSize() default 1;

    int maxSize() default 50;

    boolean notBlank() default true;
}
