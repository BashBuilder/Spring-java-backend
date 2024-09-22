package com.runner.app.runners.user;

import org.springframework.context.annotation.Bean;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserInterfaceRestClient {

    @GetExchange("/user")
    List<User> findAll();

    @GetExchange("/user/{id}")
    User findById();

}
