package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Operation(description = "this is for getting all students")
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(description = "this is for getting student by id")
    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @Operation(description = "this is for saving student")
    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }

    @Operation(description = "this is for editing student,you need write studentId also")
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, studentId);
    }

    @Operation(description = "this is for deleting student by id")
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PatchMapping("/{studentId}/teachers/{teacherId}")
    public void assignTeacherToStudent(@PathVariable Long studentId,@PathVariable Long teacherId){
        studentService.assignTeacherToStudent(studentId,teacherId);
    }

}
