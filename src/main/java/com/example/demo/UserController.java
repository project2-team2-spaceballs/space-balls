package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController (UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return this.repository.findAll();
    }


}
