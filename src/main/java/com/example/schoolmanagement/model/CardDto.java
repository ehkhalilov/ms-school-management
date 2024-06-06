package com.example.schoolmanagement.model;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private Long id;
    private String cardNumber;
    private LocalDate expireDate;
    private Student student;

    @Data
    public static class Student{
        private Long id;
        private String name;
        private String surname;
        private Double score;
        private Grade grade;
        private Integer course;
        private Boolean graduated;
    }
}
