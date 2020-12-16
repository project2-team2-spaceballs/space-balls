package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opscap")
public class OpsCapController {

    private final OpscapRepo repository;

    public OpsCapController(OpscapRepo repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<OpsCap> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public OpsCap create(@RequestBody OpsCap opsCap) {
        return this.repository.save(opsCap);

    }

}
