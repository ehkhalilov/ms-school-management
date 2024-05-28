package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
//test
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
//    @Transient
    private LocalDate birthDate;
    private Integer course;
    private boolean isGraduate;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, String surname, Double score, LocalDate birthDate, Integer course , Boolean isGraduate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.birthDate = birthDate;
        this.course = course;
        if(isGraduate == null){
            this.isGraduate = false;
        }else{
            this.isGraduate = isGraduate;
        }
    }

    public StudentEntity(String name, String surname, LocalDate birthDate , Double score, Integer course) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.score = score;
        this.course = course;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
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

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                ", birthDate=" + birthDate +
                ", course=" + course +
                '}';
    }
}
