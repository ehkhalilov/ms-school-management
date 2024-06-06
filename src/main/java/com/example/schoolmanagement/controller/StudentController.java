package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.model.Response;
import com.example.schoolmanagement.model.get.StudentGetDto;
import com.example.schoolmanagement.model.set.StudentSetDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentGetDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{studentId}")
    public StudentGetDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/saveStudent")
    public void saveStudent(@RequestBody StudentSetDto studentSetDto) {
        studentService.saveStudent(studentSetDto);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<Response<?>> updateStudentById(@PathVariable Long studentId, @RequestBody StudentSetDto studentSetDto) {
        try {
            studentService.updateStudent(studentSetDto, studentId);
            return ResponseEntity.ok(new Response<>("Successfully"));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

    @DeleteMapping("/deleteById/{studentId}")
    public ResponseEntity<Response<?>> deleteStudentById(@PathVariable Long studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok(new Response<>("Student is deleted successfully"));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

    @PatchMapping("/graduate/{studentId}")
    public ResponseEntity<Response<?>> graduate(@PathVariable Long studentId) {
        try {
            studentService.graduate(studentId);
            return ResponseEntity.ok(new Response<>("Successfully graduated"));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

    @GetMapping("/getAll/{graduate}")
    public ResponseEntity<Response<List<StudentGetDto>>> getAllStudents(@PathVariable Boolean graduate) {
        try {
            return ResponseEntity.ok(new Response<>("Successfully", studentService.getAllStudents(graduate)));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(e.getMessage(), null));
        }
    }

}
