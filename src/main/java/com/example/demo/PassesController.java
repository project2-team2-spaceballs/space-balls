package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passes")
public class PassesController {

    private final PassesRepository passes_repo;

    public PassesController(PassesRepository passes_repo) {

        this.passes_repo = passes_repo;
    }

    @GetMapping("/{sat_id}")
    public Iterable<Passes> getPassesById(@PathVariable int sat_id) {
        return this.passes_repo.getPassesById(sat_id);
    }
}
