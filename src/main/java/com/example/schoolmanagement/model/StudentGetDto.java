package com.example.schoolmanagement.model;

import java.time.LocalDate;

public class StudentGetDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Boolean isGraduate;

    public StudentGetDto() {
    }

    public StudentGetDto(Long id, String name, String surname, LocalDate birthDate, Boolean isGraduate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.isGraduate = isGraduate;
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
