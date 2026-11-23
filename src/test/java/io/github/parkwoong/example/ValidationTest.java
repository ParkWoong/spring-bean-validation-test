package io.github.parkwoong.example;

import static org.junit.jupiter.api.Assertions.*;

import io.github.parkwoong.example.util.validation.Enum;
import io.github.parkwoong.example.util.validation.EnumString;
import io.github.parkwoong.example.util.validation.Number;

import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

class ValidationTest {
    static class Sample {
        @EnumString(values = {"READY", "DONE"})
        String state;

        @Enum(
                values = {1, 2},
                notBlank = false)
        Long level;

        @Number(minSize = 1, maxSize = 3)
        Long code;

        Sample(String state, Long level, Long code) {
            this.state = state;
            this.level = level;
            this.code = code;
        }
    }

    @Test
    void checksAllowedValuesAndSize() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        assertTrue(validator.validate(new Sample("READY", null, 42L)).isEmpty());
        assertFalse(validator.validate(new Sample("OTHER", 3L, 1234L)).isEmpty());
        assertFalse(validator.validate(new Sample("DONE", 1L, -1L)).isEmpty());
    }
}
