package com.example.schoolmanagement.dao.entity;

import com.example.schoolmanagement.enums.Grade;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@DynamicInsert
public class StudentEntity {
    @Id
    private Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    private Double score;
    @Column(name = "birth_date")
    @Transient
    private LocalDate birthDate;
    private Integer course;
    @ColumnDefault("false")
    private Boolean graduated;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CardEntity card;
    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<TaskEntity> tasks;
}
