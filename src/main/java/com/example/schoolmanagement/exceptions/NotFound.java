package com.example.schoolmanagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class NotFound extends RuntimeException{
    private String code;
    private String errorMessage;

    public NotFound(String code,String errorMessage){
        super(code);
        this.code=code;
        this.errorMessage=errorMessage;
    }
}
