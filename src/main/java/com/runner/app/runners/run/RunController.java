package com.runner.app.runners.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

//    post request
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create( @RequestBody Run run){
        runRepository.create(run);
    }

//    update requests
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@PathVariable  Integer id, @RequestBody Run run){
        runRepository.update(run, id);
    }
//    delete request

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }

}
