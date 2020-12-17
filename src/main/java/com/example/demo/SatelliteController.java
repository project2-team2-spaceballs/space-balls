package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {

    private final SatelliteRepository satellite_repo;

    public SatelliteController(SatelliteRepository satellite_repo) {

        this.satellite_repo = satellite_repo;
    }

    @GetMapping("/{id}")
    public Iterable<Satellite> getSatById(@PathVariable int id) {

        return this.satellite_repo.getSatById(id);
    }


}
