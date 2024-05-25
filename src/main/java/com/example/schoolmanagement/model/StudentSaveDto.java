package com.example.schoolmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;

public class StudentSaveDto {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    private Double score;
    public StudentSaveDto() {
    }

    public StudentSaveDto(String name, String surname,
                          String fatherName, LocalDate birthDate, Double score) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.score = score;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
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

    @Override
    public String toString() {
        return "StudentSaveDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthDate=" + birthDate +
                ", score=" + score +
                '}';
    }
}
