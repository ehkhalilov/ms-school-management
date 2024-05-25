package com.example.schoolmanagement.model;

import java.sql.Date;
import java.time.LocalDate;

public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private LocalDate birthDate;
    private Integer course;
    private Boolean isGraduated;


    public StudentDto() {
    }

    public StudentDto(Long id, String name, String surname, Double score, LocalDate birthDate, Integer course, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
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

    public Boolean getGraduated() {
        return isGraduated = false;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                ", birthDate=" + birthDate +
                ", course=" + course +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
