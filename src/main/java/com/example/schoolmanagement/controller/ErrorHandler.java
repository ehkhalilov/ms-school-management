package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.exception.ValidationException;
import com.example.schoolmanagement.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handle(NotFoundException e) {
        log.error(e.getMessage());
        return new ExceptionDto(e.getCode());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handle(ValidationException e) {
        log.error(e.getMessage());
        return new ExceptionDto(e.getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return new ExceptionDto("UNEXPECTED_EXCEPTION");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ExceptionDto> handle(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<ExceptionDto> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errors.add(new ExceptionDto(field + ": " + message));
        });
        return errors;
    }
}
