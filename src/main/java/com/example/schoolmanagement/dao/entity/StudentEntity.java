package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private LocalDate birthDate;
    private Integer course;
    @Column(name = "is_graduated")
    private Boolean graduated;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CardEntity card;
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<TeacherEntity> teachers;

    public StudentEntity(String name, String surname, Double score, LocalDate birthDate, Integer course) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(score, that.score) && Objects.equals(birthDate, that.birthDate) && Objects.equals(course, that.course) && Objects.equals(graduated, that.graduated) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, score, birthDate, course, graduated, card);
    }
}
