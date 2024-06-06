package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.mapper.TaskMapper;
import com.example.schoolmanagement.model.get.TaskGetDto;
import com.example.schoolmanagement.model.set.TaskSetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final StudentRepository studentRepository;

    private TaskEntity findById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TASK_NOT_FOUND"));
    }

    public void crateTask(TaskSetDto taskSetDto){
        log.info("ActionLog.crateTask.start");
        TaskEntity taskEntity = taskMapper.mapToEntity(taskSetDto);
        taskEntity.setCreateDate(LocalDate.now());
        taskRepository.save(taskEntity);
        log.info("ActionLog.crateTask.end");
    }

    public TaskGetDto getTask(Long taskId){
        log.info("ActionLog.getTask.start");
        TaskEntity taskEntity = findById(taskId);
        TaskGetDto taskGetDto = taskMapper.mapToDto(taskEntity);
        log.info("ActionLog.getTask.end");
        return taskGetDto;
    }

    public List<TaskGetDto> getAllTasks(){
        log.info("ActionLog.getAllTasks.start");
        List<TaskEntity> taskEntities = taskRepository.findAll();
        List<TaskGetDto> taskGetDtos = taskEntities.stream().map(taskMapper::mapToDto).toList();
        log.info("ActionLog.getAllTasks.end");
        return taskGetDtos;
    }

    public void assignTask(Long studentId, Long taskId) {
        log.info("ActionLog.assignTask.start");
        TaskEntity taskEntity = findById(taskId);
        StudentEntity studentEntity = studentRepository.findById(studentId).
                orElseThrow(()->new NotFoundException("STUDENT_NOT_FOUND"));
        if(taskEntity.getStudentEntity() == studentEntity){
            taskEntity.setStudentEntity(null);
            taskEntity.setAssignedDate(null);
            log.info("ActionLog.assignTask.end.deleteTaskFromStudent " + studentId);
        }
        else {
            taskEntity.setStudentEntity(studentEntity);
            taskEntity.setAssignedDate(LocalDate.now());
            log.info("ActionLog.assignTask.end");
        }
        taskRepository.save(taskEntity);
    }

    public List<TaskGetDto> getTasksByStudentId(Long studentId) {
        log.info("ActionLog.getTasksByStudentId.start");
        List<TaskEntity> taskEntities = taskRepository.findByStudentId(studentId);
        List<TaskGetDto> taskGetDtos = taskEntities.stream().map(taskMapper::mapToDto).toList();
        log.info("ActionLog.getTasksByStudentId.end");
        return taskGetDtos;
    }

    public void deleteTask(Long taskId) {
        log.info("ActionLog.deleteTask.start");
        taskRepository.deleteById(taskId);
        log.info("ActionLog.deleteTask.end");
    }

    public void changeDueDate(Long taskId, LocalDate newDate) {
        log.info("ActionLog.changeDueDate.start");
        TaskEntity taskEntity = findById(taskId);
        taskEntity.setDueDate(newDate);
        taskRepository.save(taskEntity);
        log.info("ActionLog.changeDueDate.end");
    }

}
