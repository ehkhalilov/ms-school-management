package com.example.schoolmanagement.model;


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

    public StudentDto(Long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public StudentDto(Long id ,String name, String surname, String birthDate , Double score, Integer course) {
        this.name = name;
        this.surname = surname;

        String dateFormat = "dd-MM-yyyy"; // Example: "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        this.birthDate = LocalDate.parse(birthDate, formatter);

        this.score = score;
        this.course = course;
    }

    public StudentDto() {
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
