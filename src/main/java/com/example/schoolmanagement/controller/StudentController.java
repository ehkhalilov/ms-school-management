package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentName}/{studentSurname}")
    public StudentEntity getNameAndSurname(@PathVariable String studentName,@PathVariable String studentSurname ){
        return studentService.findByNameAndSurname(studentName, studentSurname);
    }
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PatchMapping("/editgraduate/{studentId}")
    public void editGraduate(@PathVariable Long studentId,@RequestBody StudentSaveDto studentSaveDto){
        studentService.editGraduate(studentId,studentSaveDto);
    }
    @PostMapping
    public void postStudent(@RequestBody StudentSaveDto studentSaveDto){

                studentService.saveStudent(studentSaveDto);
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
