package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Mark;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: nijataghayev
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithMarkDto {
    private Long id;
    @Schema(description = "This is name of student", required = true)
    private String name;
    @Schema(description = "This is surname of student", required = true)
    private String surname;
    @Schema(description = "This is score of student", required = true)
    private Double score;
    @Schema(description = "This is birthdate of student", required = true)
    private LocalDate birthDate;
    @Schema(description = "This is course of student")
    private Integer course;
    private Boolean graduated;
    private Mark mark;
    private Card card;
    private List<Task> tasks;
    private List<Teacher> teachers;

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

    @Data
    public static class Teacher {
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String subject;
    }
}
