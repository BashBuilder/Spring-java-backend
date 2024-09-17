package com.runner.app.runners.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunDbRepository {

    private final JdbcTemplate jdbcClient;

    public RunDbRepository(JdbcTemplate jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        try {
            return jdbcClient.query("SELECT * FROM `run`", (rs, rowNum) ->
                new Run(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("miles"),
                    rs.getTimestamp("started_on").toLocalDateTime(),
                    rs.getTimestamp("completed_on").toLocalDateTime(),
                    Location.valueOf(rs.getString("location").toUpperCase())
                ));
        } catch (Exception e) {
            // Log the exception and rethrow or handle it
            e.printStackTrace();
            throw new RuntimeException("Error querying the database", e);
        }
    }
}
