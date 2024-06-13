package com.example.schoolmanagement.model;

import com.example.schoolmanagement.model.enums.Subject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {
    private int id;
    @Schema(description = "This is name of teacher",
            required = true, defaultValue = "Name")
    private String name;
    public String surname;
    public LocalDate birthday;
    private Subject subject;
    private List<Student> students;

    @Data
    public static class Student{
        private Long id;
        private String name;
        private String surname;
        private Double score;
    }

}
