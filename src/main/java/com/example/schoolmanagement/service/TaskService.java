package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.TaskDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final TaskRepository taskRepository;
    private final StudentMapper studentMapper;
    private final TaskMapper taskMapper;

    public List<TaskDto> getTasks() {
        log.info("ActionLog.getAllTasks.starts");

        List<TaskEntity> tasks = taskRepository.findAll();
        var taskDtos = tasks.stream()
                .map(taskMapper::taskToTaskDto)
                .toList();
        log.info("ActionLog.getAllTasks.ends");

        return taskDtos;
    }

    public void deleteTask(Long taskID) {
        log.info("ActionLog.deleteTask.starts taskID {} ", taskID);
        taskRepository.deleteById(taskID);
        log.info("ActionLog.deleteTask.ends taskId {}", taskID);
    }

    public void saveTask(TaskDto taskDto) {
        log.info("ActionLog.saveTask.starts task {}", taskDto);
        try {
            var taskEntity = taskMapper.mapToEntity(taskDto);
            taskRepository.save(taskEntity);
        } catch (Exception e) {
            logger.error("Error saving task: ", e);
            throw new RuntimeException("Error saving student", e);
        }
        log.info("ActionLog.saveTask.ends task {}", taskDto);
    }

    public void updateTask(Long taskID, TaskDto taskDto) {
        log.info("ActionLog.updateTask.starts taskId {}", taskID);
        TaskEntity taskEntity = taskRepository.findById(taskID)
                .orElseThrow(() -> new RuntimeException("TASK_NOT_FOUND"));

        taskEntity.setTitle(taskDto.getTitle());

        if (taskDto.getStudent() != null) {
            StudentEntity studentToUpdate;
            if (taskDto.getStudent().getId() != null) {
                Long studentId = taskDto.getStudent().getId();
                studentToUpdate = studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
            } else {
                studentToUpdate = new StudentEntity(
                        taskDto.getStudent().getName(),
                        taskDto.getStudent().getSurname(),
                        taskDto.getStudent().getBirthDate(),
                        taskDto.getStudent().getScore(),
                        taskDto.getStudent().getCourse()
                );
            }
            taskEntity.setStudent(studentToUpdate);
        }

        taskRepository.save(taskEntity);
        log.info("ActionLog.updateTask.ends taskId {}", taskID);
    }

}
