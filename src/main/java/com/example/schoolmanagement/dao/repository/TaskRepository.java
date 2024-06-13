package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TaskRepository extends JpaRepository<TaskEntity, Long> {
}
