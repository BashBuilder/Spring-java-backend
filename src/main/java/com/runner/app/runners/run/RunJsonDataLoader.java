package com.runner.app.runners.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);

    private final RunDbRepository runDbRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(RunDbRepository runDbRepository, ObjectMapper objectMapper) {
        this.runDbRepository = runDbRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        if(runDbRepository.count() <= 1) {
            log.info("Runs not found in the in-memory database, loading from json data");
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                runDbRepository.saveAll(allRuns.runs());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            log.info("Runs already loaded into in-memory database");
        }
    }
}
