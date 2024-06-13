package com.example.schoolmanagement.model.student;

import com.example.schoolmanagement.model.card.CardWithoutStudentDto;
import com.example.schoolmanagement.model.enums.Mark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithoutTaskDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Boolean graduate;
    private Mark mark;
    private CardWithoutStudentDto card;
}
