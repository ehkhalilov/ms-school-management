package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.TeacherDto;
import com.example.schoolmanagement.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @Operation(summary = "Get all teachers", description = "Retrieve a list of all teachers.")
    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Operation(summary = "Get a teacher by ID", description = "Retrieve a teacher by their ID.")
    @GetMapping("/{teacherId}")
    public TeacherDto getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @Operation(summary = "Add a new teacher", description = "Add a new teacher to the database.")
    @PostMapping
    public void addTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
    }

    @Operation(summary = "Assign a student to a teacher", description = "Assign a specific student to a teacher by their IDs.")
    @PatchMapping("/{teacherId}/students/{studentId}")
    public void assigneeTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        teacherService.assigneeStudentToTeacher(teacherId, studentId);
    }

    @Operation(summary = "Delete a teacher", description = "Delete a teacher from the database by their ID.")
    @DeleteMapping("/{studentId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}
