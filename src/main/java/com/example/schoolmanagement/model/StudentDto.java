package com.example.schoolmanagement.model;


import com.example.schoolmanagement.enums.Grade;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private Grade grade;
    private Integer course;
    private Boolean graduated;
    private Card card;
    private List<Task> tasks;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Card{
        private Long id;
        private String cardNumber;
        private LocalDate expireDate;
    }

    @Data
    public static class Task{
        private Long id;
        private String title;
    }
}
