package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.TaskDto;
import com.example.schoolmanagement.service.StudentService;
import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }


    @PostMapping
    public void saveTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto, taskId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
