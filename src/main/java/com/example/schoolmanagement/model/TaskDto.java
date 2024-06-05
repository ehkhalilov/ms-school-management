package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author: nijataghayev
 */

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
        private LocalDate birthDate;
        private Integer course;
        private Boolean graduated;
    }
}
