package com.runner.app.runners.run;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/runs")
public class RunDataController {

    private final RunDbRepository runDbRepository;
    public RunDataController(RunDbRepository runDbRepository) {
        this.runDbRepository = runDbRepository;
    }

    @GetMapping("")
    public List<Run> initialize() {
        return runDbRepository.findAll();
    }

    @GetMapping("/{id}")
    public Run getById(@PathVariable Integer id) {
        if(!runDbRepository.findById(id).isPresent()){
            throw new RunNotFoundException("No such id in the database");
        }
        return runDbRepository.findById(id).get();
    }

    @PostMapping("")
    public void create(@Valid @RequestBody Run run) {
        runDbRepository.create(run);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Run run) {
        runDbRepository.update(id, run);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        runDbRepository.delete(id);
    }
}

