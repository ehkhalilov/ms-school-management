package com.example.schoolmanagement.model;

import com.example.schoolmanagement.dao.enums.Score;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentGetDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Boolean isGraduate;
    private Score score;

}
