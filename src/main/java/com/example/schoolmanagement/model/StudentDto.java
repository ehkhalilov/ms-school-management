package com.example.schoolmanagement.model;


import com.example.schoolmanagement.model.enums.Mark;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDto {
    private Long id;
//    @NotBlank(message = "name is required")
    private String name;
//    @NotBlank(message = "surname is required")
    private String surname;
    private LocalDate birthDate;
    private Double score;
    private Integer course;
    private Boolean isGraduate;
    private Enum<Mark> mark;

    public StudentDto(Long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public StudentDto(Long id ,String name, String surname, String birthDate , Double score, Integer course , Boolean isGraduate) {
        this.name = name;
        this.surname = surname;

        String dateFormat = "dd-MM-yyyy"; // Example: "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        this.birthDate = LocalDate.parse(birthDate, formatter);

        if(score != null){
            this.mark = Mark.getMarkByScore(score);
        }
        if(isGraduate != null){
            this.isGraduate = isGraduate;
        }else{
            this.isGraduate = false;
        }
        this.score = score;
        this.course = course;
    }

    public StudentDto() {
    }


    public Boolean getGraduate() {
        return isGraduate;
    }

    public void setGraduate(Boolean graduate) {
        isGraduate = graduate;
    }

    public Enum<Mark> getMark() {
        return mark;
    }
    public void setMark(Enum<Mark> mark) {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                ", course=" + course +
                '}';
    }
}
