package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Grade;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class StudentDto {

    private Long studentid;
    private String name;
    private String surname;
    private boolean isGraduate;
    private Grade score;

}
