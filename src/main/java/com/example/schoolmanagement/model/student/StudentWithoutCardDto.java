package com.example.schoolmanagement.model.student;



import com.example.schoolmanagement.model.card.CardWithoutStudentDto;
import com.example.schoolmanagement.model.enums.Mark;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithoutCardDto {
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
