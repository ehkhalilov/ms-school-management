package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentid;
    private String name;
    private String surname;
    private Double score;

//    @Column(name = "isGraduate")
    @Column(columnDefinition = "boolean default false")
    private Boolean isGraduate;



}

