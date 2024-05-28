package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Mark;

import java.time.LocalDate;

/**
 * @author: nijataghayev
 */
public class StudentWithMarkDto {
    private Long id;
    private String name;
    private String surname;
    private Double score;
    private LocalDate birthDate;
    private Integer course;
    private Boolean graduated;
    private Mark mark;

    public StudentWithMarkDto() {
    }

    public StudentWithMarkDto(Long id, String name, String surname, Double score, LocalDate birthDate, Integer course, Boolean graduated, Mark mark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.birthDate = birthDate;
        this.course = course;
        this.graduated = graduated;
        this.mark = mark;
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
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentWithMarkDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                ", birthDate=" + birthDate +
                ", course=" + course +
                ", graduated=" + graduated +
                ", mark=" + mark +
                '}';
    }
}
