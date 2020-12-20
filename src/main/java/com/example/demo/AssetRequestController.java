package com.example.demo;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/asset-request")
public class AssetRequestController {

    private final AssetRequestRepository repository;

    public AssetRequestController(AssetRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<AssetRequest> getAssetRequest() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public AssetRequest getAssetRequestById(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteAssetRequestById(@PathVariable Long id) {
        this.repository.deleteById(id);
        return "Request Deleted.";
    }

    @GetMapping("/userId/{userId}")
    public Iterable<AssetRequest> getAssetRequestByUserId(@PathVariable Long userId) {
        Iterable<AssetRequest> result = this.repository.findByUserId(userId);
        return result;
    }


    @PostMapping("")
    public Long addNewRequest(@RequestBody AssetRequest newRequest) {
        return this.repository.save(newRequest).getId();
    }
}
