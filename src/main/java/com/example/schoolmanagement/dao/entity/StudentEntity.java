package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Double score;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Integer course;
    @Column(name = "is_graduated")
    private Boolean isGraduated;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, String surname, Double score, LocalDate birthDate, Integer course, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.birthDate = birthDate;
        this.course = course;
        this.isGraduated = isGraduated;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Boolean getGraduated() {
        return isGraduated;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getBirthDate(LocalDate birthDate) {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
