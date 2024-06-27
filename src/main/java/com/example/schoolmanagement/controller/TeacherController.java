package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.get.TeacherGetDto;
import com.example.schoolmanagement.model.set.TeacherSetDto;
import com.example.schoolmanagement.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PostMapping
    public void saveTeacher(@RequestBody @Valid TeacherSetDto teacherSetDto) {
        teacherService.saveTeacher(teacherSetDto);
    }

    @GetMapping("/{teacherId}")
    public TeacherGetDto getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @GetMapping
    public List<TeacherGetDto> getTeacher() {
        return teacherService.getAllTeachers();
    }

    @PatchMapping("/{teacherId}/lessons/{lessonId}/assign")
    public void assignLesson(@PathVariable Long teacherId, @PathVariable Long lessonId){
        teacherService.assignLesson(teacherId, lessonId);
    }
    @PatchMapping("/{teacherId}/lessons/{lessonId}/remove")
    public void removeLessonFromTeacher(@PathVariable Long teacherId, @PathVariable Long lessonId){
        teacherService.removeLessonFromTeacher(teacherId, lessonId);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId){
        teacherService.deleteTeacher(teacherId);
    }

}
