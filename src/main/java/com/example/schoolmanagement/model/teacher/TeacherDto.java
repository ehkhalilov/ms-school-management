package com.example.schoolmanagement.model.teacher;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.enums.Subject;
import com.example.schoolmanagement.model.student.StudentDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Schema(description = "Name of teahcer")
    private String name;
    @Schema(description = "Surname of teahcer")
    private String surname;
    @Schema(description = "Birthdate of teahcer")
    private LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    private Subject subject;
    @ManyToMany(mappedBy = "teachers")
    private List<StudentDto> students;
}
