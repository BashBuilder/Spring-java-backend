package com.runner.app.runners.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> home(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run getRunById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()) {
            throw new IllegalStateException("No run found");
        }
        return run.get();
    }
}
