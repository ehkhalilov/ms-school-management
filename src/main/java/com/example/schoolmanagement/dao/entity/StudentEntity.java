package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
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
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "is_graduate")
    private Boolean graduate;
    private Double score;

}
