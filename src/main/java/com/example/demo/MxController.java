package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mx")
public class MxController {
    private final MxRepository repository;
    public MxController(MxRepository repository) {
        this.repository=repository;
    }
    @GetMapping("/all")
    public Iterable<MxTask> all() {
        return this.repository.findAll();
    }
    @GetMapping("/sensor/{searchsensor}")
    public Iterable<MxTask> sensor(@PathVariable String searchsensor){
        return this.repository.findBySensor(searchsensor);
    }
    @PostMapping("/request")
    public MxTask request(@RequestBody MxTask task){
        return this.repository.save(task);
    }
    @GetMapping("/search")
    public Iterable<MxTask> search(@RequestParam String searchstring){
        return this.repository.doSearch(searchstring);
    }

}
