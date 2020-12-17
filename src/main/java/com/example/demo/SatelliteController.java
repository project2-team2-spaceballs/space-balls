package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {

    private final SatelliteRepository satellite_repo;

    public SatelliteController(SatelliteRepository satellite_repo) {

        this.satellite_repo = satellite_repo;
    }


    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/{id}")
    public Iterable <Satellite> getSatById(@PathVariable int id) {

        return this.satellite_repo.getSatById(id);
    }


}
