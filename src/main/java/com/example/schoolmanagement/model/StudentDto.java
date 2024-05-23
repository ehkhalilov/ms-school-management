package com.example.schoolmanagement.model;

import java.time.LocalDate;

public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Boolean isGraduated;

    public StudentDto() {}

    public StudentDto(Long id, String name, String surname, LocalDate birthDate, Double score, Integer course, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.score = score;
        this.course = course;
        this.isGraduated = isGraduated;
    }

    public StudentDto( String name, String surname, LocalDate birthDate, Double score, Integer course, Boolean isGraduated) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.score = score;
        this.course = course;
        this.isGraduated = isGraduated;
    }

    public Boolean getGraduated() {
        return isGraduated = false;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", score=" + score +
                ", course=" + course +
                '}';
    }
}
