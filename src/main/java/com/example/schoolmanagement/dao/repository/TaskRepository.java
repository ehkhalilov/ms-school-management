package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query(value = "SELECT * FROM tasks WHERE student_id = ?1", nativeQuery = true)
    List<TaskEntity> findByStudentId(Long studentId);
}
