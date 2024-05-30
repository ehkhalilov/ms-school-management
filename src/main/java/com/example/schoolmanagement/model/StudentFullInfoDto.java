package com.example.schoolmanagement.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class StudentFullInfoDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private LocalDate birthDate;
    private String course;
    private Boolean graduated;

}
