package com.example.demo;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/passes")
public class PassesController {

    private final PassesRepository passes_repo;

    public PassesController(PassesRepository passes_repo) {

        this.passes_repo = passes_repo;
    }
    @GetMapping("")
    public Iterable <Passes> getPasses() {
        return this.passes_repo.findAll();
    }

    @GetMapping("/{sat_id}")
    public Iterable<Passes> getPassesBySatId(@PathVariable int sat_id) {
        return this.passes_repo.getPassesBySatId(sat_id);
    }
}
