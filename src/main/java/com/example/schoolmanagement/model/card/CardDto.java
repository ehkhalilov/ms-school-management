package com.example.schoolmanagement.model.card;


import com.example.schoolmanagement.model.student.StudentDto;
import com.example.schoolmanagement.model.student.StudentWithoutCardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private String id;
    private Long cardNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
    private StudentWithoutCardDto student;
}
