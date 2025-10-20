package com.example.jareerai.dto;

import groovy.transform.ToString;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    @NotBlank(message = "prompt must not be blank")
    private String prompt;

}
