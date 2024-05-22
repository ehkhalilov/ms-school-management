package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.model.Response;
import com.example.schoolmanagement.model.StudentGetDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response<List<StudentGetDto>>> getAllStudents() {
        try {
            return ResponseEntity.ok(new Response<>("Successfully", studentService.getAllStudents()));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

    @GetMapping("/getStudent{studentId}")
    public ResponseEntity<Response<StudentGetDto>> getStudent(@PathVariable Long studentId) {
        try {
            return ResponseEntity.ok(new Response<>("Successfully", studentService.getStudent(studentId)));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

    @PostMapping("/saveStudent")
    public void saveStudent(@RequestBody StudentSaveDto studentSaveDto) {
        studentService.saveStudent(studentSaveDto);
    }

    @PutMapping("/{studentId}")
    public void put(@PathVariable Integer studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
    }
}
