package com.example.sampleapi.exception;

public class NoteArgumentNotValidException extends RuntimeException {
    public NoteArgumentNotValidException(String message) {
        super(message);
    }
}
