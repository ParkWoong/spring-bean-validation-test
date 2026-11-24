package io.github.parkwoong.example;

import io.github.parkwoong.example.util.validation.Enum;
import io.github.parkwoong.example.util.validation.EnumString;
import io.github.parkwoong.example.util.validation.Number;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationController {
    @PostMapping("/api/validate")
    public Input validate(@Valid @RequestBody Input input) {
        return input;
    }

    public static class Input {
        @EnumString(values = {"READY", "DONE"})
        public String state;

        @Enum(
                values = {1, 2},
                notBlank = false)
        public Long level;

        @Number(minSize = 1, maxSize = 3)
        public Long code;
    }
}
