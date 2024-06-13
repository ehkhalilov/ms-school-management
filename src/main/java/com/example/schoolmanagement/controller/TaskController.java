package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.TaskDto;
import com.example.schoolmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
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

/**
 * @author: nijataghayev
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks.")
    @GetMapping
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @Operation(summary = "Save a new task", description = "Save a new task to the database.")
    @PostMapping
    public void saveTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @Operation(summary = "Update a task", description = "Update an existing task by its ID.")
    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto, taskId);
    }

    @Operation(summary = "Delete a task", description = "Delete a task from the database by its ID.")
    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
