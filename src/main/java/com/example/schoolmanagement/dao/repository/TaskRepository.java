package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByDeadlineIsNull();

    List<TaskEntity> findAllByStatusIsNot(TaskStatus taskStatus);
}
