package com.runner.app.runners;

import com.runner.app.runners.run.Location;
import com.runner.app.runners.run.Run;
import com.runner.app.runners.run.RunDbRepository;
import com.runner.app.runners.user.User;
import com.runner.app.runners.user.UserInterfaceRestClient;
import com.runner.app.runners.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	UserInterfaceRestClient userInterfaceRestClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserInterfaceRestClient.class);

	}


//	the bean and command line runner runs the first time when the application starts the first time
	@Bean
	CommandLineRunner runner(UserInterfaceRestClient client) {
		return args -> {
//			List<User> users = client.getUsers();
//
//			User singleUser = client.getUserById(1);
//
//			System.out.println(singleUser);

//			List<User> users = client.findAll();



//			User singleUser = client.getUserById(1);
//
//			System.out.println(users);

		};
	};

}
