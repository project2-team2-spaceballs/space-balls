package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Date;
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

    @PatchMapping("/{id}")
    public Logs updateEntry(@RequestBody Logs logUpdate) throws ResponseStatusException {
        Optional<Logs> result = this.repository.findById(logUpdate.getId());

        if(!result.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found.");
        }

        Logs currentEntry = result.get();
//        LogHistory historyEntry = new LogHistory();
//        historyEntry.setLog_id(currentEntry.getId());
//        historyEntry.setDetails(currentEntry.getDetails());
//        historyEntry.setOriginal_dtg(currentEntry.getEntry_dtg());
//        historyEntry.setUpdated_dtg(new Date());
//        this.historyRepository.save(historyEntry);

        if(logUpdate.getDetails() != null){
            currentEntry.setDetails(logUpdate.getDetails());
        }
        if(logUpdate.getEntry_dtg() != null){
            currentEntry.setEntry_dtg(logUpdate.getEntry_dtg());
        }
        if(logUpdate.getSensor_id() != null){
            currentEntry.setSensor_id(logUpdate.getSensor_id());
        }
        if(logUpdate.isArchived()){
            currentEntry.setArchived(logUpdate.isArchived());
        }
        return this.repository.save(currentEntry);
    }

    @GetMapping("/find")
    public Iterable<Logs> findByDetails(@RequestParam String search){
        return this.repository.findByDetailsContaining(search);
    }
}
