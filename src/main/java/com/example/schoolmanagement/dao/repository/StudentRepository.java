package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByTeachersId(String teacherName);
}
