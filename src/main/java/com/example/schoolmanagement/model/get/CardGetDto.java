package com.example.schoolmanagement.model.get;

import com.example.schoolmanagement.enums.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CardGetDto {
    private Long id;
    private String cardNumber;
    private LocalDate expireDate;
    private Student student;

    @Data
    public static class Student{
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private Boolean graduate;
        private Score score;
    }

}
