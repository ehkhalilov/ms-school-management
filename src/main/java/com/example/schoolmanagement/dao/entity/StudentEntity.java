package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

//test
@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Double score;
    @Column(name = "birth_date")
//    @Transient
    private LocalDate birthDate;
    private Integer course;
    private boolean graduate;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, String surname, Double score, LocalDate birthDate, Integer course , Boolean isGraduate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.birthDate = birthDate;
        this.course = course;
        this.graduate = Objects.requireNonNullElse(isGraduate, false);
    }

}
