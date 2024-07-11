package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.CreateModel;
import com.example.schoolmanagement.model.TeacherDto;
import com.example.schoolmanagement.model.UpdateModel;
import com.example.schoolmanagement.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @Operation(description = "This is controller for manage teachers")
    @PostMapping
    public void addTeacher(@RequestBody @Validated(CreateModel.class) TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
    }

    @PatchMapping("/{teacherId}/students/{studentId}")
    public void addTeacher(
            @PathVariable Long teacherId, @PathVariable Long studentId
    ) {
        teacherService.assigneeStudentToTeacher(teacherId, studentId);
    }

    @GetMapping("/{teacherId}")
    public TeacherDto getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @PostMapping("/change-teachers")
    public void changeTeachers() {
        teacherService.changeTeachers();
    }

    @PutMapping("/{id}")
    public void updateTeacher(
            @PathVariable Long id,
            @RequestBody @Validated(UpdateModel.class) TeacherDto teacherDto) {

    }
}
