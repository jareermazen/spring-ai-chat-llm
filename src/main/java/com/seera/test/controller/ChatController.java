package com.seera.test.controller;

import com.seera.test.dto.ChatRequest;
import com.seera.test.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/chat", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String chat(@Valid @RequestBody ChatRequest request) {
        return chatService.chat(request.getPrompt());
    }
}
