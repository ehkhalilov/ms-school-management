package com.example.schoolmanagement.model;


import com.example.schoolmanagement.model.enums.Mark;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StudentDto {
    private Long id;
//    @NotBlank(message = "name is required")
    private String name;
//    @NotBlank(message = "surname is required")
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Boolean graduate;
    private Mark mark;


//    public StudentDto(Long id ,String name, String surname, String birthDate , Double score, Integer course , Boolean isGraduate) {
//        this.name = name;
//        this.surname = surname;
//
//        String dateFormat = "dd-MM-yyyy"; // Example: "yyyy-MM-dd"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
//        this.birthDate = LocalDate.parse(birthDate, formatter);
//
//        if(score != null){
//            this.mark = Mark.getMarkByScore(score);
//        }
//        this.isGraduate = Objects.requireNonNullElse(isGraduate, false);
//        this.score = score;
//        this.course = course;
//    }


}
