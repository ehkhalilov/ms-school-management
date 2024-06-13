package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentFullInfoDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }
    @GetMapping("/{studentId}/is_graduated")
    public String isStudentGraduated(@PathVariable Long studentId) {
        return studentService.isStudentGraduated(studentId);
    }
    @GetMapping("/{studentId}/grade")
    public String getStudentGrade(@PathVariable Long studentId) {
        return studentService.getStudentGrade(studentId);
    }
    @GetMapping("/graduated_only")
    public List<StudentDto> getGraduatedStudents() {
        return studentService.getGraduatedStudents();
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(
            @PathVariable Long studentId,
            @RequestBody StudentFullInfoDto studentFullInfoDto) {
        studentService.updateStudent(studentFullInfoDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @DeleteMapping("/{studentId}/delete/tasks/{taskId}")
    public void deleteTask(
            @PathVariable Long studentId,
            @PathVariable Long taskId) {
        studentService.deleteTask(studentId, taskId);
    }

    @PatchMapping("/{studentId}/update_is_graduated")
    public void updateStudentIsGraduated(
            @PathVariable Long studentId,
            @RequestParam(required = true) Boolean isGraduated) {
        studentService.updateStudentIsGraduated(studentId, isGraduated);
    }
    @PatchMapping("/{studentId}/teachers/{teacherId}")
    public void assignStudentToTeacher(
            @PathVariable Long studentId,
            @PathVariable Long teacherId
    ){
        studentService.assignStudentToTeacher(studentId, teacherId);
    }
}
