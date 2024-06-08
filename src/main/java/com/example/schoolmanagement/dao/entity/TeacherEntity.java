package com.example.schoolmanagement.dao.entity;

import com.example.schoolmanagement.model.SUBJECT;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private SUBJECT subject;
    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}