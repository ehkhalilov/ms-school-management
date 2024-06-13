package com.example.schoolmanagement.model;

import com.example.schoolmanagement.model.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private Card card;
    private List<Task> tasks;
    private List<Teacher> teachers;

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
    @Data
    public static class Teacher{
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private Subject subject;
    }

}
