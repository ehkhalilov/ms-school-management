package com.example.schoolmanagement.model.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSetDto {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    private Double score;
    private CardSetDto cardSetDto;
}
