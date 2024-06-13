package com.example.schoolmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private String message;
    private String code;
    public NotFoundException (String code , String message){
        super(code);
        this.code = code;
        this.message = message;
    }
}
