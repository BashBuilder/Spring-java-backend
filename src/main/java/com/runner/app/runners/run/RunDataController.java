package com.runner.app.runners.run;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/runs")
public class RunDataController {

//    private final RunDataRepository runDataRepository;
//    private final RunDbRepository runDbRepository;
//
//    public RunDataController(RunDataRepository runDataRepository, RunDbRepository runDbRepository) {
//        this.runDataRepository = runDataRepository;
//        this.runDbRepository = runDbRepository;
//    }

//    @GetMapping("")
//    public List<Run> initialize() {
//        return runDataRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Run getById(@PathVariable Integer id) {
//        if(!runDataRepository.findById(id).isPresent()){
//            throw new RunNotFoundException("No such id in the database");
//        }
//        return runDataRepository.findById(id).get();
//    }
//
//    @PostMapping("")
//    public void create(@Valid @RequestBody Run run) {
//        runDataRepository.save(run);
//    }
////
////    @PutMapping("/{id}")
//    public void update(@PathVariable int id, @RequestBody Run run) {
//        runDataRepository.updateBy(id, run);
//    }
////
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        runDataRepository.delete(runDbRepository.findById(id).get());
//    }
}

