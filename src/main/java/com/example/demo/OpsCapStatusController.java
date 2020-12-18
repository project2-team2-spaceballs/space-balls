package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/opscapstatus")
    public class OpsCapStatusController {

        private final OpsCapStatusRep repository;

        public OpsCapStatusController(OpsCapStatusRep repository) {
            this.repository = repository;
        }

        @GetMapping("")
        public Iterable<OpsCapStatus> all() {
            return this.repository.findAll();
        }


    }

