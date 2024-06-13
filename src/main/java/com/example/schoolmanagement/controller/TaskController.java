package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.TaskDto;
import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/{taskID}")
    public TaskDto getTask(@PathVariable Long taskID){
        return taskService.getTask(taskID);
    }
    @PostMapping
    public void saveTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }
    @PatchMapping("/{taskID}/students/{studentID}")
    public void assignTaskToStudent(
            @PathVariable Long taskID,
            @PathVariable Long studentID) {
        taskService.assignTaskToStudent(taskID, studentID);
    }
    @PutMapping
    public void updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto);
    }
    @DeleteMapping("/{taskID}")
    public void deleteTask(@PathVariable Long taskID) {
        taskService.deleteTask(taskID);
    }

}
