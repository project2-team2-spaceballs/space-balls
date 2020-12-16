package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PosNegController {

//    private final SatelliteRepository satellite_repo;
//
//    public PosNegController(SatelliteRepository satellite_repo) {
//        this.satellite_repo = satellite_repo;
//    }


    @RequestMapping("/satellites")
    public String test() { return "++ Gellar Field Holding: Satellites Secure ++"; }


    @RequestMapping("/satellite_passes")
    public String test2() { return "++ Gellar Field Holding: Passes Secure ++"; }
}
