package com.runner.app.runners.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        Integer miles,
        LocalDateTime startedon,
        LocalDateTime completedon,
        Location location
        ) {}
