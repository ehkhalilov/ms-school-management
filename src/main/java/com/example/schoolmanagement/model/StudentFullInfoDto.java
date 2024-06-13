package com.example.schoolmanagement.model;

import com.example.schoolmanagement.model.enums.Subject;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentFullInfoDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private LocalDate birthDate;
    private Subject subject;
    private Boolean graduated;
    private Card card;
    private List<Task> tasks;

    @Data
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
