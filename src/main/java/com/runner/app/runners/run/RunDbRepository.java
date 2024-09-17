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
import java.util.Optional;

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

    public Optional<Run> findById(Integer id){
        String query = "SELECT * FROM `run` WHERE id = ?";
        Run run = jdbcClient.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
            new Run(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("miles"),
                rs.getTimestamp("started_on").toLocalDateTime(),
                rs.getTimestamp("completed_on").toLocalDateTime(),
                Location.valueOf(rs.getString("location").toUpperCase())
            ));
        return Optional.ofNullable(run);
    }

    public void create(Run run) {
        String query =
                "INSERT INTO `run` (id, title, miles, started_on, completed_on, location) VALUES (?,?,?,?,?,?)";
        jdbcClient.update(query,
            run.id(),
            run.title(),
            run.miles(),
            run.startedon(),
            run.completedon(),
            run.location().name()
        );
    }

    public void update(Run run, Integer id) {
        String query =
                "UPDATE `run` SET title =?, miles =?, started_on =?, completed_on =?, location =? WHERE id =?";
        jdbcClient.update(query,
            run.title(),
            run.miles(),
            run.startedon(),
            run.completedon(),
            run.location().name(),
            id
        );
    }

    public void delete(Integer id) {
        String query = "DELETE FROM `run` WHERE id =?";
        jdbcClient.update(query, id);
    }
}
