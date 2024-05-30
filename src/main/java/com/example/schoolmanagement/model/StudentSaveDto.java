package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveDto {

    private Long studentid;
    private String name;
    private String surname;
    private boolean isGraduate;
    private Double score;

}
