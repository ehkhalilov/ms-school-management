package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Card card;
    private List<Task> tasks;

    @Data
    public static class Card {
        private Long id;
        private String cardNumber;
        private LocalDate expireDate;
    }

    @Data
    public static class Task {
        private Long id;
        private String title;
    }
}
