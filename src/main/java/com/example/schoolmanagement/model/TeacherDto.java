package com.example.schoolmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: nijataghayev
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {
    private Long id;
    @Schema(description = "This is name of teacher", required = true)
    private String name;
    @Schema(description = "This is surname of teacher", required = true)
    private String surname;
    @Schema(description = "This is birth date of teacher", required = true)
    private LocalDate birthDate;
    @Schema(description = "This is subject of teacher", required = true)
    private String subject;
    private List<Student> students;

    @Data
    public static class Student{
        private Long id;
        private String name;
        private String surname;
        private Integer course;
        private Boolean graduated;
    }
}
