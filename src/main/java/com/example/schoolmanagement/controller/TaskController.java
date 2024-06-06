package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.get.TaskGetDto;
import com.example.schoolmanagement.model.set.TaskSetDto;
import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public void createTask(@RequestBody TaskSetDto taskSetDto){
        taskService.crateTask(taskSetDto);
    }

    @GetMapping("/getTask/{taskId}")
    public TaskGetDto getTask(@PathVariable Long taskId){
        return taskService.getTask(taskId);
    }
    @GetMapping("/getAll")
    public List<TaskGetDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/assignTask/{studentId}/{taskId}")
    public void assignTask(@PathVariable Long studentId, @PathVariable Long taskId){
        taskService.assignTask(studentId, taskId);
    }

    @GetMapping("/getTasksOfStudent/{studentId}")
    public List<TaskGetDto> getTasksByStudentId(@PathVariable Long studentId){
        return taskService.getTasksByStudentId(studentId);
    }

    @DeleteMapping("/delete{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @PatchMapping("/changeDueDate/{taskId}/{newDate}")
    public void changeDueDate(@PathVariable Long taskId, @PathVariable LocalDate newDate){
        taskService.changeDueDate(taskId, newDate);
    }

}
