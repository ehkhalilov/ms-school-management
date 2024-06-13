package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.task.TaskDto;
import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{taskID}")
    public TaskDto getTask(@PathVariable String taskID){
        log.info("Action.getTaks.start taskID : {}" , taskID);
        var task = taskService.getTask(taskID);
        log.info("Action.getTaks.end taskID : {}" , taskID);
        return task;
    }

    @PatchMapping("/{taskID}/deAssign")
    public String deAssignTask(@PathVariable String taskID){
        log.info("Action.deAssignTask.start taskID : {}" , taskID);
        taskService.deAssignTask(taskID);
        log.info("Action.deAssignTask.end taskID : {}" , taskID);
        return "Task Successfully Deassigned !";
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        log.info("Action.getAllTasks.start");
        var taskDtoList = taskService.getAllTasks();
        log.info("Action.getAllTasks.end");
        return taskDtoList;

    }

    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
    }

    @PatchMapping("/{taskID}/assign/{studentID}")
    public void assignTask(@PathVariable String taskID, @PathVariable Long studentID) {
        log.info("Action.assigntTask.start studentId : {} | taskId : {}" , taskID , studentID);
        taskService.assignTaskToStudent(taskID, studentID);
        log.info("Action.assigntTask.end studentId : {} | taskId : {}" , taskID , studentID);
    }

    @PutMapping("/{taskID}")
    public void updateTask(@RequestBody TaskDto taskDto){
        log.info("Action.updateTask.start  task : {}" , taskDto);
        taskService.updateTask(taskDto);
        log.info("Action.updateTask.end  task : {}" , taskDto);
    }

    @DeleteMapping("/{taskID}")
    public void deleteTask(@PathVariable String taskID){
        log.info("Action.deleteTask.start  taskId : {}" , taskID);
        taskService.deleteTask(taskID);
        log.info("Action.deleteTask.delete  taskId : {}" , taskID);
    }
}
