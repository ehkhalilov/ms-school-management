package com.example.schoolmanagement.dao.entity;

import com.example.schoolmanagement.model.enums.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    @Column(name = "birthdate")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Subject subject;
    @Column(name = "is_graduated")
    private Boolean graduated;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CardEntity card;
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<TaskEntity> tasks;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH}
    )
    @JoinTable(
            name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers;
}
