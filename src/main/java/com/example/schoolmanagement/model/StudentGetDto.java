package com.example.schoolmanagement.model;

import com.example.schoolmanagement.dao.enums.Score;

import java.time.LocalDate;

public class StudentGetDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Boolean isGraduate;
    private Score score;

    public StudentGetDto() {
    }

    public StudentGetDto(Long id, String name, String surname, LocalDate birthDate, Boolean isGraduate, Score score) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.isGraduate = isGraduate;
        this.score = score;
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

    public Boolean getGraduate() {
        return isGraduate;
    }

    public void setGraduate(Boolean graduate) {
        isGraduate = graduate;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentGetDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", isGraduate=" + isGraduate +
                '}';
    }
}
