package com.example.sampleapi.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
