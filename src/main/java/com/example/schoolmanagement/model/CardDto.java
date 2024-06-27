package com.example.schoolmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    @Schema(description = "it's unique id",title = "id")
    private Long id;
    @Schema(description = "it's cardNumber",title = "cardNumber")
    private String cardNumber;
    @Schema(description = "it's expireDate,date format",title = "expireDate")
    private LocalDate expireDate;
    @Schema(description = "it's student of card,there is one to one relation between them",title = "student")
    private Student student;

    @Data
    public static class Student {
        private Long id;
        private String name;
        private Double score;
    }
}
