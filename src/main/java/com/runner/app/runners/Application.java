package com.runner.app.runners;

import com.runner.app.runners.run.Location;
import com.runner.app.runners.run.Run;
import com.runner.app.runners.run.RunDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


//	the bean and command line runner runs the first time when the application starts the first time
	@Bean
	CommandLineRunner runner(RunDbRepository runDbRepository) {
		return args -> {
			log.info("Application started Successfully");
		};
	};

}
