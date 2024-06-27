package com.example.schoolmanagement.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final String message;
    private final String log;
    public ValidationException(String message, String log) {
        super(message);
        this.message = message;
        this.log = log;
    }
}
