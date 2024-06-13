package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithMarkDto;
import com.example.schoolmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
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

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "Get all students", description = "Retrieve a list of all students with their marks.")
    @GetMapping
    public List<StudentWithMarkDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get a student by ID", description = "Retrieve a student by their ID, including their marks.")
    @GetMapping("/{studentId}")
    public StudentWithMarkDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @Operation(summary = "Save a new student", description = "Save a new student to the database.")
    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }

    @Operation(summary = "Update a student", description = "Update an existing student's information.")
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, studentId);
    }

    @Operation(summary = "Assign a task to a student", description = "Assign a specific task to a student by their IDs.")
    @PutMapping("/{studentId}/tasks/{taskId}")
    public StudentDto assignTask(@PathVariable Long studentId, @PathVariable Long taskId) {
        return studentService.assignTask(studentId, taskId);
    }

    @Operation(summary = "Delete a student", description = "Delete a student from the database by their ID.")
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @Operation(summary = "Delete a task from a student", description = "Delete a specific task assigned to a student by their IDs.")
    @DeleteMapping("/{studentId}/task/{taskId}")
    public void deleteTask(@PathVariable Long studentId, @PathVariable Long taskId) {
        studentService.deleteTask(studentId, taskId);
    }

    @Operation(summary = "Delete all tasks from a student", description = "Delete all tasks assigned to a student by their ID.")
    @DeleteMapping("/{studentId}/alltasks")
    public void deleteAllTasks(@PathVariable Long studentId) {
        studentService.deleteAllTasks(studentId);
    }

    @Operation(summary = "Mark a student as graduated", description = "Mark a student as graduated by their ID.")
    @PatchMapping("/graduated/{studentId}")
    public void graduatedStudent(@PathVariable Long studentId) {
        studentService.graduatedStudent(studentId);
    }
}