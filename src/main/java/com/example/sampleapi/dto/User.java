package com.example.sampleapi.dto;

import jdk.jshell.execution.LoaderDelegate;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private long userId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
}
