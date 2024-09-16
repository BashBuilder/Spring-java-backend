package com.runner.app.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<Run>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "today", 20, LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), Location.INDOOR));
        runs.add(new Run(2, "yesterday", 15, LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), Location.OUTDOOR));
    }
}
