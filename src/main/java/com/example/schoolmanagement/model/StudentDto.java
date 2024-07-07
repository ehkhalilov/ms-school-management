package com.example.schoolmanagement.model;

import com.example.schoolmanagement.validations.MailCheck;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @Schema(description = "it's unique id",title = "id")
    private Long id;
    @Schema(description = "it's name",title = "name",defaultValue = "name")
    @MailCheck
    private String name;
    @Schema(description = "it's score",title = "score")
    @NotNull
    private Double score;
    @Schema(description = "it's card of student, there is one to one relation between them",title = "card")
    private Card card;
    @Schema(description = "it's tasks of students, there is one to many relation between them",title = "tasks")
    private List<Task> tasks;
    @Schema(description = "it's teachers of students, there is many to many relation between them",title = "teachers")
    private List<TeacherRequestDto> teachers;

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
