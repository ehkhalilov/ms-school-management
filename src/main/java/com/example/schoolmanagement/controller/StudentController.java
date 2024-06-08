package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Grade;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithGradeDto;
import com.example.schoolmanagement.model.TaskDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping("/{studentId}/grade")
    public Grade getStudentGrade(@PathVariable Long studentId) {
        return studentService.getStudentGrade(studentId);
    }


    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        logger.info("Received POST request with student data: {}", studentDto);
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        logger.info("Received PUT request for student ID: {} with data: {}", studentId, studentDto);
        studentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
        logger.info("Received DELETE request for student ID: {}", studentId);
        studentService.deleteStudent(studentId);
    }

    @DeleteMapping("/{studentID}/{taskId}/v1")
    public void deleteTaskV1(@PathVariable Long studentID, @PathVariable Long taskId) {
        studentService.deleteTaskV1(studentID, taskId);
    }

    @DeleteMapping("/{studentID}/{taskId}/v2")
    public void deleteTaskV2(@PathVariable Long studentID, @PathVariable Long taskId) {
        studentService.deleteTaskV2(studentID, taskId);
    }

    @GetMapping("/{studentId}/with-grade")
    public StudentWithGradeDto getStudentWithGrade(@PathVariable Long studentId) {
        return studentService.getStudentWithGrade(studentId);
    }

    @PutMapping("/{studentId}/add-task")
    public StudentDto addTask(@PathVariable Long studentId, @RequestBody TaskDto taskDto) {
        return studentService.addTask(studentId, taskDto);
    }

    @PutMapping("/{studentId}/{taskId}")
    public StudentDto assignTask(@PathVariable Long studentId, @PathVariable Long taskId) {
        return studentService.assignTask(studentId, taskId);
    }

}
