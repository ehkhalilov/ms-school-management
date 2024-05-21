package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void post(@RequestBody StudentDto studentDto) {
        logger.info("Received POST request with student data: {}", studentDto);
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/{studentId}")
    public void put(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        logger.info("Received PUT request for student ID: {} with data: {}", studentId, studentDto);
        studentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
        logger.info("Received DELETE request for student ID: {}", studentId);
        studentService.deleteStudent(studentId);
    }
}
