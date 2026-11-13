package com.example.sampleapi.exception;

public class LoginArgumentNotValidException extends RuntimeException {
    public LoginArgumentNotValidException(String message) {
        super(message);
    }
}
