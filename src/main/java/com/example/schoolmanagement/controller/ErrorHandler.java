package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.exception.ValidationException;
import com.example.schoolmanagement.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: nijataghayev
 */

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
}
