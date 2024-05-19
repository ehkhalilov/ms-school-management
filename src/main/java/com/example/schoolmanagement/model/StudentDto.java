package com.example.schoolmanagement.model;

public class StudentDto {
    private Long id;
    private String name;
    private Double score;

    public StudentDto(Long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
