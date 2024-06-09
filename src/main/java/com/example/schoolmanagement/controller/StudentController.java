package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.student.StudentDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

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
        log.info("Action.saveStudent.start student {}" , studentDto);
        studentService.saveStudent(studentDto);
        log.info("Action.saveStudent.start student {}" , studentDto);
    }

    @PutMapping("/{studentId}")
    public void put(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
            studentService.deleteStudent(studentId);
    }

    @GetMapping("/graduate")
    public List<StudentDto> getGraduatedStdents(){
        return studentService.getGraduatedStudents();
    }
    @PatchMapping("/{studentId}/graduate")
    public void patch(@PathVariable Long studentId){
        studentService.graduateStudent(studentId);
    }

}
