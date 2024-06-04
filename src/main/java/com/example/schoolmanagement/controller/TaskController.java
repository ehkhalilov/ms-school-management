package com.example.schoolmanagement.controller;


import com.example.schoolmanagement.model.TaskDto;
import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;


    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public void saveTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @DeleteMapping("/{taskID}")
    public void delete(@PathVariable Long taskID) {
        taskService.deleteTask(taskID);
    }

    @PutMapping("/{taskID}")
    public void updateTask(@PathVariable Long taskID, @RequestBody TaskDto taskDto) {
        taskService.updateTask(taskID, taskDto);
    }
}
