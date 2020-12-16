package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogsController {

    private final LogsRepository repository;

    public LogsController(LogsRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Logs> all(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Logs> findById(@PathVariable Long id){
        return this.repository.findById(id);
    }

    @PostMapping("")
    public Logs create(@RequestBody Logs log) {
        return this.repository.save(log);
    }

}
