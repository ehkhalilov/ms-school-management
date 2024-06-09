package com.example.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author: nijataghayev
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String subject;
}
