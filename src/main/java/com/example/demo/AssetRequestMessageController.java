package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asset-request/message")
public class AssetRequestMessageController {

    private final AssetRequestMessageRepository repository;

    public AssetRequestMessageController (AssetRequestMessageRepository repository) {
        this.repository = repository;
    }


    @GetMapping("")
    public Iterable<AssetRequestMessage> getUsers() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public AssetRequestMessage getMessageById(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }


}
