package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    private Long studentid;
    private String name;
    private String surname;

    public StudentEntity() {
    }

    public StudentEntity(Long studentid, String name, String surname, Double score, LocalDate birthDate, Integer course) {
        this.studentid = studentid;
        this.name = name;
        this.surname = surname;

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

}
