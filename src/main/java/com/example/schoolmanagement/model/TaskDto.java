package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        private Double score;
        private Grade grade;
        private Integer course;
        private Boolean graduated;
    }
}
