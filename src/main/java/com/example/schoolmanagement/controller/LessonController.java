package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.get.LessonGetDto;
import com.example.schoolmanagement.model.set.LessonSetDto;
import com.example.schoolmanagement.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/lessons")
@RestController
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public void saveTeacher(@RequestBody LessonSetDto lessonSetDto) {
        lessonService.saveLesson(lessonSetDto);
    }

    @GetMapping("/{lessonId}")
    public LessonGetDto getTeacher(@PathVariable Long lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @GetMapping
    public List<LessonGetDto> getTeacher() {
        return lessonService.getAllLessons();
    }

    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable Long lessonId){
        lessonService.deleteLesson(lessonId);
    }
}
