package com.runner.app.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.Instant;
import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        @Positive
        Integer miles,
        LocalDateTime startedon,
        LocalDateTime completedon,
        Location location
        ) {
        public Run {
            if(startedon.isAfter(completedon)) {
                throw new IllegalArgumentException("Started on date cannot be after completed on date");
            }
        }

}
