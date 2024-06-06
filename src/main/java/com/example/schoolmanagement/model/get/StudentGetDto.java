package com.example.schoolmanagement.model.get;

import com.example.schoolmanagement.dao.enums.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGetDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Boolean graduate;
    private Score score;
    private Card card;

    @Data
    public static class Card{
        private Long id;
        private String cardNumber;
        private LocalDate expireDate;
    }
}
