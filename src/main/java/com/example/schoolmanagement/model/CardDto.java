package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private Long id;
    private String cardNumber;
    private LocalDate expireDate;
    private Student student;

    @Data
    public static class Student {
        private Long id;
        private String name;
        private Double score;
    }
}
