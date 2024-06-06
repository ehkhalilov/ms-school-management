package com.example.schoolmanagement.model.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardSetDto {
    private String cardNumber;
    private LocalDate expireDate;
}
