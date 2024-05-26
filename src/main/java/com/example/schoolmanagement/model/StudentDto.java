package com.example.schoolmanagement.model;

import java.time.LocalDate;

public class StudentDto {
    private Long id;
    private String name;
    private Double score;
    private LocalDate birthDate;
    private Integer course;
    private Boolean isGraduated;

    public StudentDto(Long id, String name, Double score, LocalDate birthDate, Integer course, Boolean isGraduated) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthDate = birthDate;
        this.course = course;
        this.isGraduated = isGraduated;
    }

    public StudentDto() {}

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
        return isGraduated;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }

    @Override
    public String toString() {
        return "StudentsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
