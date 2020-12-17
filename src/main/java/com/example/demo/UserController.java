package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController (UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("")
    public Iterable<User> getUsers() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    @PostMapping("")
    public String addNewUser(@RequestBody User newUser) {
        this.repository.save(newUser);
        return "User saved in database.";
    }

}
