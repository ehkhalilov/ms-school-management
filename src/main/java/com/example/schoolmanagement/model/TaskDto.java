package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private Student student;

    @Data
    public static class Student{
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private Double score;
        private Integer course;
    }
}
