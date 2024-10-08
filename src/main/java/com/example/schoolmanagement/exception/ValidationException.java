package com.example.schoolmanagement.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final String code;
    private final String message;

    public ValidationException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
