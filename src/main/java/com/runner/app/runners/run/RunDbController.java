package com.runner.app.runners.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/db/runs")
public class RunDbController {

    private final RunDbRepository runDbRepository;

    public RunDbController(RunDbRepository runDbRepository) {
        this.runDbRepository = runDbRepository;
    }

    @GetMapping("")
    public List<Run> initialize()
    {
        return runDbRepository.findAll();
    }
}
