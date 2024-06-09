package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.get.TeacherGetDto;
import com.example.schoolmanagement.model.set.TeacherSetDto;
import com.example.schoolmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/save")
    public void saveTeacher(@RequestBody TeacherSetDto teacherSetDto) {
        teacherService.saveTeacher(teacherSetDto);
    }

    @GetMapping("/getTeacher/{teacherId}")
    public TeacherGetDto getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @GetMapping("/getAll")
    public List<TeacherGetDto> getTeacher() {
        return teacherService.getAllTeachers();
    }

    @PutMapping("/assignLesson/{teacherId}/{lessonId}")
    public void assignLesson(@PathVariable Long teacherId, @PathVariable Long lessonId){
        teacherService.assignLesson(teacherId, lessonId);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId){
        teacherService.deleteTeacher(teacherId);
    }

}
