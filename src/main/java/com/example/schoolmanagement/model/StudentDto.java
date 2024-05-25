package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Grade;
import jakarta.persistence.Id;

public class StudentDto {

    @Id
    private Long studentid;

    private String name;
    private String surname;
    private boolean isGraduate;
    private Grade score;


    public StudentDto(Long studentid, String name, String surname,Grade score) {
        this.studentid = studentid;
        this.name = name;
        this.surname = surname;
        this.score=score;
    }

    public StudentDto() {
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
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

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
    }


    public Grade getScore() {
        return score;
    }

    public void setScore(Grade score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", surname=" + surname +
                '}';
    }
}
