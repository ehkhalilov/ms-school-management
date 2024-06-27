package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "lessons")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long akts;

    @ManyToMany(mappedBy = "lessonEntities", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<TeacherEntity> teacherEntities;

    @ManyToMany(mappedBy = "lessonEntities", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<StudentEntity> studentEntities;
}
