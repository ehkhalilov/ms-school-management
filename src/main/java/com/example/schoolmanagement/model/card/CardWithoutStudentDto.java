package com.example.schoolmanagement.model.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardWithoutStudentDto {
    private String id;
    private Long cardNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
}
