package com.example.schoolmanagement.model;

import com.example.schoolmanagement.enums.Grade;

public class StudentSaveDto {

    private Long studentid;
    private String name;
    private String surname;
    private boolean isGraduate;
    private Double score;

    public StudentSaveDto(Long id, String name, String surname, Double score) {
        this.studentid = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
    }

    public StudentSaveDto() {
    }

    @Override
    public String toString() {
        return "StudentSaveDto{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isGraduate=" + isGraduate +
                ", score=" + score +
                '}';
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
