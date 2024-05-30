package com.example.schoolmanagement.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentSaveDto {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    private Double score;

}
