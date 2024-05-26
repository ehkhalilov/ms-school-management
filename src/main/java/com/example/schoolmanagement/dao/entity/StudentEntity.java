package com.example.schoolmanagement.dao.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
//import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name="jt_students") // Table in which the columns have taken
public class StudentEntity {
    @Id
    private Long id;
    private String name;
    private Double score;
    private LocalDate birthDate;
    private Integer course;
    private Boolean isGraduated;

    public StudentEntity() {}

    public StudentEntity(Long id, String name, Double score, LocalDate birth_date, Integer course, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthDate = birth_date;
        this.course = course;
        this.isGraduated = isGraduated;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birth_date) {
        this.birthDate = birth_date;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Boolean getIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(Boolean isGraduated) {
        this.isGraduated = isGraduated;
    }
}
