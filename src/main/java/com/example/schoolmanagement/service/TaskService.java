package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.TaskDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: nijataghayev
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;
    private final TaskMapper taskMapper;

    public List<TaskDto> getTasks() {
        log.info("ActionLog.getTasks.start");
        List<TaskEntity> tasks = taskRepository.findAll();
        List<TaskDto> taskDtoList = tasks.stream()
                .map(taskMapper::mapToDto)
                .toList();
        log.info("ActionLog.getTasks.end");

        return taskDtoList;
    }

    public void saveTask(TaskDto taskDto) {
        log.debug("ActionLog.saveTask.start task {}", taskDto);
        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskRepository.save(taskEntity);
        log.debug("ActionLog.saveTask.end task {}", taskDto);
    }

    public void updateTask(TaskDto taskDto, Long taskId) {
        log.info("ActionLog.updateTask.start taskId {}", taskId);
        TaskEntity existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> {
                    log.error("ActionLog.assingTask.id {} not found", taskId);
                    return new RuntimeException("TASK_NOT_FOUND");
                });
        TaskEntity updateTask = taskMapper.mapToEntity(taskDto);
        existingTask.setTitle(updateTask.getTitle());

        if (existingTask.getStudent() != null) {
            StudentEntity studentEntity;
            if (taskDto.getStudent().getId() != null) {
                Long studentId = taskDto.getStudent().getId();
                studentEntity = studentRepository.findById(studentId)
                        .orElseThrow(() -> {
                            log.error("ActionLog.updateStudent.id {} not found", studentId);
                            return new RuntimeException("TASK_NOT_FOUND");
                        });
            } else {
                studentEntity = new StudentEntity(
                        taskDto.getStudent().getName(),
                        taskDto.getStudent().getSurname(),
                        taskDto.getStudent().getScore(),
                        taskDto.getStudent().getBirthDate(),
                        taskDto.getStudent().getCourse()
                );
            }
            existingTask.setStudent(studentEntity);
        }
        taskRepository.save(existingTask);
        log.info("ActionLog.updateTask.end taskId {}", taskId);
    }

    public void deleteTask(Long taskId){
        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteStudent.id {} not found", taskId);
                    return new RuntimeException("TASK_NOT_FOUND");
                });
        taskRepository.delete(taskEntity);
    }
}
