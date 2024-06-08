package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CardEntity card;
    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaskEntity> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers;

    public StudentEntity(String name, String surname, LocalDate birthDate, Double score, Integer course) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getScore(), that.getScore()) &&
                Objects.equals(getBirthDate(), that.getBirthDate()) &&
                Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getCard(), that.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getScore(), getBirthDate(), getCourse(), getCard());
    }
}