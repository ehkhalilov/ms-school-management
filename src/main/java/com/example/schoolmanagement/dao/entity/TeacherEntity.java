package com.example.schoolmanagement.dao.entity;

import com.example.schoolmanagement.model.enums.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teacher")
@Getter
@Setter

public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    private Subject subject;

    @ManyToMany(mappedBy = "teachers")
    private List<StudentEntity> students;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthDate, that.birthDate) && subject == that.subject && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthDate, subject, students);
    }
}
