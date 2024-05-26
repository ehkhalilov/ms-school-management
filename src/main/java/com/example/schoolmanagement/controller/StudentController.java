package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.service.StudentService;
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
@RequestMapping("/students/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all-data")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}/info")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/{studentId}/set-data")
    public void post(
            @PathVariable Long studentId,
            @RequestBody StudentDto studentDto
    ) {
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/{studentId}/update-data")
    public void put(
            @PathVariable(required = false) Long studentId,
            @RequestBody StudentDto studentDto
    ) {
        studentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/deleted/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
