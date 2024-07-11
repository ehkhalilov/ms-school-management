package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.enums.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void setDeadlineForTask() {
        var taskList = taskRepository.findAllByDeadlineIsNull();
        taskList.forEach(task -> {
            task.setDeadline(LocalDate.now());
        });
        taskRepository.saveAll(taskList);
    }

    public void checkDeadlineForTask() {
        var taskList = taskRepository.findAllByStatusIsNot(TaskStatus.EXPIRED);
        taskList.forEach(task -> {
            task.getDeadline().isBefore(LocalDate.now());
            task.setStatus(TaskStatus.EXPIRED);
        });
        taskRepository.saveAll(taskList);
    }
}
