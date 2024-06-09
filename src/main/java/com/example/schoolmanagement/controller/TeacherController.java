package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.TeacherDto;
import com.example.schoolmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    public TeacherDto getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @PostMapping
    public void addTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.addTeacher(teacherDto);
    }

    @PatchMapping("/{teacherId}/students/{studentId}")
    public void assigneeTeacher(@PathVariable Long teacherId, @PathVariable Long studentId){
        teacherService.assigneeStudentToTeacher(teacherId, studentId);
    }
}
