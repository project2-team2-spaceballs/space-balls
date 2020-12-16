package com.example.demo;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public String addNewUser(@RequestBody AssetRequestMessage newMessage) {
        this.repository.save(newMessage);
        return "Message saved in database.";
    }
}
