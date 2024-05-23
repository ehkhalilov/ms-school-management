package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentid;
    private String name;
    private String surname;

//    @Column(name = "isGraduate")
    private boolean isGraduate;

    public StudentEntity() {
    }

    public StudentEntity(Long studentid, String name, String surname, boolean isGraduate) {
        this.studentid = studentid;
        this.name = name;
        this.surname = surname;
        this.isGraduate = isGraduate;
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

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isGraduate=" + isGraduate +
                '}';
    }
}

