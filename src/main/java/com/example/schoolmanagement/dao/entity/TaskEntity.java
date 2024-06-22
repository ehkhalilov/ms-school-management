package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentEntity student;


}
