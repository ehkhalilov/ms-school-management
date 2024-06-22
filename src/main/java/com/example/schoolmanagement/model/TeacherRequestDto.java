package com.example.schoolmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherRequestDto {

    @Schema(description = "it's unique id", title = "id")
    private Long id;
    @Schema(description = "it's name for teacher", title = "name")
    private String name;
    @Schema(description = "it's surname for teacher", title = "surname")
    private String surname;
    @Schema(description = "it's birthdate for teacher", title = "birthDate")
    private LocalDate birthDate;

}
