package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::mapToDto).toList();
    }

    public TaskDto getTask(Long taskId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow();
        return taskMapper.mapToDto(taskEntity);
    }

    public void saveTask(TaskDto taskDto) {
        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskRepository.save(taskEntity);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void updateTask(TaskDto taskDto,Long taskId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow();
        taskEntity.setTitle(taskDto.getTitle());
        taskRepository.save(taskEntity);
    }
}
