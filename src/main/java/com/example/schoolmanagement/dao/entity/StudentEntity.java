package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    private Long id;
    private String name;
    private String surname;
    private Double score;
    @Column(name = "birthdate")
    private LocalDate birthDate;
    private String course;
    @Column(name = "is_graduated")
    private Boolean graduated;

}
