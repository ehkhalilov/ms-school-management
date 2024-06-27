package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.get.StudentGetDto;
import com.example.schoolmanagement.model.set.StudentSetDto;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentGetDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentGetDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentSetDto studentSetDto) {
        studentService.saveStudent(studentSetDto);
    }

    @PutMapping("/{studentId}")
    public void updateStudentById(@PathVariable Long studentId, @RequestBody StudentSetDto studentSetDto) {
        studentService.updateStudent(studentSetDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PatchMapping("/{studentId}/graduate")
    public void graduate(@PathVariable Long studentId) {
        studentService.graduate(studentId);
    }

    @GetMapping("/graduate/{graduate}")
    public List<StudentGetDto> getStudentsByGraduate(@PathVariable Boolean graduate) {
        return studentService.getStudentsByGraduate(graduate);
    }

    @PatchMapping("/{studentId}/lessons/{lessonId}/assign")
    public void assignLesson(@PathVariable Long studentId, @PathVariable Long lessonId){
        studentService.assignLesson(studentId, lessonId);
    }
    @PatchMapping("/{studentId}/lessons/{lessonId}/remove")
    public void removeLessonFromTeacher(@PathVariable Long studentId, @PathVariable Long lessonId){
        studentService.removeLessonFromStudent(studentId, lessonId);
    }

}
