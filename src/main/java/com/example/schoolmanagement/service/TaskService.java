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

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final StudentRepository studentRepository;

    private TaskEntity getTaskByID(Long taskId) {
        return taskRepository
                .findById(taskId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getTaskByID id={}", taskId);
                    return new RuntimeException("TASK_NOT_FOUND");}
                );
    }

    public List<TaskDto> getAllTasks() {
        log.info("ActionLog.getAllTasks.start");

        List<TaskEntity> taskEntityList = taskRepository.findAll();
        List<TaskDto> taskDtoList = taskMapper.mapToDtoList(taskEntityList);

        log.info("ActionLog.getAllTasks.end");

        return taskDtoList;
    }
    public TaskDto getTask(Long taskID) {
        log.info("ActionLog.getTask.start taskID={}", taskID);

        TaskDto taskDto = taskMapper.mapToDto(getTaskByID(taskID));

        log.info("ActionLog.getTask.end taskDTO={}", taskDto);

        return taskDto;
    }
    public void saveTask(TaskDto taskDto) {
        log.info("ActionLog.saveTask.start taskDTO={}", taskDto);

        taskRepository.save(taskMapper.mapToEntity(taskDto));

        log.info("ActionLog.saveTask.end taskDTO={}", taskDto);
    }
    public void assignTaskToStudent(Long taskID, Long studentID) {
        log.info("ActionLog.assignTaskToStudent.start taskID={}", taskID);

        TaskEntity taskEntity = getTaskByID(taskID);
        StudentEntity studentEntity = studentRepository.findById(studentID).orElseThrow(() -> {
            log.error("ActionLog.getStudentByID id={}", studentID);
            return new RuntimeException("Student_NOT_FOUND");}
        );

        taskEntity.setStudent(studentEntity);
        taskRepository.save(taskEntity);

        log.info("ActionLog.assignTaskToStudent.end taskID={}", taskID);
    }
    public void updateTask(TaskDto taskDto){
        log.info("ActionLog.updateTask.start taskDTO={}", taskDto);

        taskRepository.save(taskMapper.mapToEntity(taskDto));

        log.info("ActionLog.updateTask.end taskDTO={}", taskDto);
    }
    public void deleteTask(Long taskID) {
        log.info("ActionLog.deleteTask.start taskID={}", taskID);

        taskRepository.deleteById(taskID);

        log.info("ActionLog.deleteTask.end taskID={}", taskID);
    }

}
