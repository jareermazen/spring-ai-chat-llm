package com.example.jareerai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
        //        return builder.defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory())).build();
    }
}
