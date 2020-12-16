package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs/comments")
public class LogCommentsController {

    private final LogCommentsRepository repository;
    public LogCommentsController(LogCommentsRepository repository){
        this.repository = repository;
    }

    @GetMapping("/{log_id}")
    public Iterable<LogComments> findByLogId(@PathVariable Long log_id){
        return this.repository.findByLogId(log_id);
    }

    @PostMapping("")
    public LogComments create(@RequestBody LogComments logComments){
        return this.repository.save(logComments);
    }

}
