package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.exception.ValidationException;
import com.example.schoolmanagement.model.get.ExceptionGetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionGetDto handle(NotFoundException e){
        log.error(e.getLog());
        return new ExceptionGetDto(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionGetDto handle(ValidationException e){
        log.error(e.getLog());
        return new ExceptionGetDto(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionGetDto handle(MethodArgumentNotValidException e){
        e.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError fieldError) {
                log.error("AgeLimitValidator failed for field: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                log.error("AgeLimitValidator error: {}", error.getDefaultMessage());
            }
        });
        return new ExceptionGetDto("VALIDATION_FAILED");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionGetDto handle(Exception e){
        log.error(e.getMessage());
        return new ExceptionGetDto("UNEXPECTED_EXCEPTION");
    }

}
