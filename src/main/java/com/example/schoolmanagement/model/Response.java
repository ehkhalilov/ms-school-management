package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response <T>{
    private String message;
    private T data;

    public Response(String message) {
        this.message = message;
    }

    public Response(T data) {
        this.data = data;
    }

}
