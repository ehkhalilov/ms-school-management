package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    }
}
