package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dao.entity.StudentEntity;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
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
    public void postStudent(@RequestBody StudentDto studentDto){

                studentService.saveStudent(studentDto);
    }

    @PutMapping("{studentId}")
    public void editStudent(@PathVariable Long studentId,@RequestBody StudentDto studentDto){

        studentService.updateStudent(studentDto,studentId);

    }

    @GetMapping("/getGraduate")
    public List<StudentDto> getGraduate(){

        return studentService.filterForGraduate();

    }



    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
