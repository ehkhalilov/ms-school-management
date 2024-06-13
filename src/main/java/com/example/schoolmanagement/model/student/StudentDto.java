package com.example.schoolmanagement.model.student;



import com.example.schoolmanagement.model.card.CardWithoutStudentDto;
import com.example.schoolmanagement.model.enums.Mark;
import com.example.schoolmanagement.model.task.TaskDto;
import com.example.schoolmanagement.model.task.TaskWithoutStudentDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Boolean graduate;
    private Mark mark;
    private CardWithoutStudentDto card;
    private List<TaskWithoutStudentDto> task;




}
