package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private SUBJECT subject;
    private List<StudentDto> students;

    @Data
    public static class StudentDto {
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private Double score;
        private Integer course;
    }
}