package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exceptions.NotFound;
import com.example.schoolmanagement.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handler(NotFound e){
        log.error(e.getErrorMessage());
        return new ExceptionDto(e.getCode());
    }
}
