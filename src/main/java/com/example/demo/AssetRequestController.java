package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset-request")
public class AssetRequestController {

    private final AssetRequestRepository repository;

    public AssetRequestController (AssetRequestRepository repository) {this.repository = repository;}

    @GetMapping("")
    public Iterable<AssetRequest> getAssetRequest() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public AssetRequest getAssetRequestById(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    @PostMapping("")
    public String addNewRequest(@RequestBody AssetRequest newRequest) {
        this.repository.save(newRequest);
        return "Request saved in database.";
    }
}
