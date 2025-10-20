package com.seera.test.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import com.seera.test.dto.ChatResponse;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ChatResponse chat(String prompt) {
        String content = chatClient
                .prompt(prompt)
                .call()
                .content();
        return new ChatResponse(content);
    }
}
