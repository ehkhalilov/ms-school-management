package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.enums.Mark;
import com.example.schoolmanagement.model.task.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public TaskDto getTask(String taskId){
        var task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("TASK_NOT_FOUND"));
        return taskMapper.mapToDto(task);
    }
    public void createTask(TaskDto taskDto){
        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskRepository.save(taskEntity);
    }

    public List<TaskDto> getAllTasks(){
        List<TaskEntity> taskEntity = taskRepository.findAll();
        System.out.println(studentMapper.mapToStudentWithoutTaskDto(taskEntity.get(0).getStudent()));
        return taskEntity.stream().map(e -> {
            var dto = taskMapper.mapToDto(e);
            var studentDto = dto.getStudent();
            studentDto.setMark(Mark.getMarkByScore(studentDto.getScore()));
            return dto;

        }).toList();
    }

    public void assignTaskToStudent(String taskID , Long studentID){
        var studentEntity = studentRepository.findById(studentID).orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        var taskEntity = taskRepository.findById(taskID).orElseThrow(() -> new RuntimeException("TASK_NOT_FOUND"));
//        var convertedTask = taskMapper.mapToTaskWithoutStudentDto(taskEntity);
        taskEntity.setStudent(studentEntity);
        taskRepository.save(taskEntity);
    }

    public void deAssignTask(String taskID){
        var task = taskRepository.findById(taskID).orElseThrow(() -> new RuntimeException("TASK_NOT_FOUND"));
        task.setStudent(null);
        taskRepository.save(task);
    }

    public void updateTask(TaskDto taskDto){
        var taksEntity = taskMapper.mapToEntity(taskDto);
        taskRepository.save(taksEntity);
    }

    public void deleteTask(String taskID){
        taskRepository.deleteById(taskID);
    }

}
