package com.runner.app.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        @Positive
        Integer miles,
        LocalDateTime startedon,
        LocalDateTime completedon,
        Location location,
//        Adding this field specifically for spring data jdbc
        @Version
        Integer version
        ) {
        public Run {
            if(startedon.isAfter(completedon)) {
                throw new IllegalArgumentException("Started on date cannot be after completed on date");
            }
        }

}
