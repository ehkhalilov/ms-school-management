package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query(value = "SELECT * FROM students WHERE is_graduate = ?1", nativeQuery = true)
    List<StudentEntity> getStudentsByGraduate(Boolean graduate);

}
