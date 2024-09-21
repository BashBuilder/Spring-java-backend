package com.runner.app.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class RunRepository {
    private final List<Run> runs = new ArrayList<Run>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs
            .stream()
            .filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
//        it can also be applied like this down here
//        if (existingRun.isPresent()) {
//            runs.set(runs.indexOf(existingRun.get()), run);
//        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id() == id);
    }

//    @PostConstruct
//    private void init() {
//        runs.add(new Run(1, "today", 20, LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), Location.INDOOR), 0);
//        runs.add(new Run(2, "yesterday", 15, LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), Location.OUTDOOR));
//    }

}
