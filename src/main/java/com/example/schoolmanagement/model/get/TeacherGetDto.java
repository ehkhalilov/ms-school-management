package com.example.schoolmanagement.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherGetDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private List<LessonGetDto> lessonGetDtos;
}
