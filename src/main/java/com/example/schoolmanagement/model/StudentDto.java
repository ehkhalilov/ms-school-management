package com.example.schoolmanagement.model;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
}
