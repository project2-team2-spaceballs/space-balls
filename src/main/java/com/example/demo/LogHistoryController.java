package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs/history")
public class LogHistoryController {

    private final LogHistoryRepository repository;

    public LogHistoryController(LogHistoryRepository repository){
        this.repository = repository;
    }

    @GetMapping("/{log_id}")
    public Iterable<LogHistory> findByLogId(@PathVariable Long log_id){
        return this.repository.findByLogId(log_id);
    }

    @PostMapping("")
    public LogHistory create(@RequestBody LogHistory logHistory){
        return this.repository.save(logHistory);
    }
}
