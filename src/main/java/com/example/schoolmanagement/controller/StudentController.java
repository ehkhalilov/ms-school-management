package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.student.StudentDto;
import com.example.schoolmanagement.model.student.StudentWithoutTaskDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<StudentDto> getAllStudents() {
        log.info("Action.getAllStudents.start");
        var studentList = studentService.getAllStudents();
        log.info("Action.getAllStudents.end");
        return studentList;
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        log.info("Action.getStudent.start studentID : {}" , studentId);
        var student = studentService.getStudent(studentId);
        log.info("Action.getStudent.end studentID : {}" , studentId);
        return student;
    }

    @PostMapping
    public void post(@RequestBody StudentDto studentDto) {
        log.info("Action.saveStudent.start student {}", studentDto);
        studentService.saveStudent(studentDto);
        log.info("Action.saveStudent.start student {}", studentDto);
    }

    @PutMapping("/{studentId}")
    public void put(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        log.info("Action.updateStudent.start studentId : {} | student {}", studentId , studentDto);
        studentService.updateStudent(studentDto, studentId);
        log.info("Action.updateStudent.end studentId : {} | student {}", studentId , studentDto);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId) {
        log.info("Action.deleteStudent.start studentId : {}" , studentId);
        studentService.deleteStudent(studentId);
        log.info("Action.deleteStudent.end studentId : {}" , studentId);
    }

    @GetMapping("/graduate")
    public List<StudentDto> getGraduatedStdents() {
        log.info("Action.getGraduatedStdents.start");
        var graduatedList = studentService.getGraduatedStudents();
        log.info("Action.getGraduatedStdents.end");
        return graduatedList;
    }

    @PatchMapping("/{studentId}/graduate")
    public void patch(@PathVariable Long studentId) {
        log.info("Action.graduateStudent.start  studentId : {}" , studentId);
        studentService.graduateStudent(studentId);
        log.info("Action.graduateStudent.end  studentId : {}" , studentId);
    }

    @GetMapping("/teacher/{teacherID}")
    public List<StudentDto> getStudentsByTeacher(@PathVariable String teacherID){
        return studentService.getStudentsByTeacher(teacherID);
    }

}
