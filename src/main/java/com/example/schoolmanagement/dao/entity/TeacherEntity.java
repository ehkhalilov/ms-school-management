package com.example.schoolmanagement.dao.entity;

import com.example.schoolmanagement.model.enums.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Subject subject;
    @ManyToMany(
            mappedBy = "teachers",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH}
    )
    private List<StudentEntity> students;
}
