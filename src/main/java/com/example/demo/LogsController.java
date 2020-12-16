package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogsController {

    private final LogsRepository repository;

    private final LogHistoryRepository historyRepository;

    public LogsController(LogsRepository repository, LogHistoryRepository historyRepository){
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    @GetMapping("")
    public Iterable<Logs> all(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Logs> findById(@PathVariable Long id){
        return this.repository.findById(id);
    }

    @PostMapping("")
    public Logs create(@RequestBody Logs log) {
        return this.repository.save(log);
    }

//    @PatchMapping("/{id}")
//    public String updateEntry(@RequestBody Logs logUpdate){
//        Optional<Logs> currentEntry = this.repository.findById(logUpdate.getId());
//        if(currentEntry.isEmpty()){
//            return
//        }
//    }

}
