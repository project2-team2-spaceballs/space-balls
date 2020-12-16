package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
