package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.teacher.TeacherDto;
import com.example.schoolmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        log.info("Action.getAllTeacher.start");
        var teacherDtos = teacherService.getAllTeachers();
        log.info("Action.getAllTeacher.end");
        return teacherDtos;
    }

    @GetMapping("/{teacherID}")
    public TeacherDto getTeacher(@PathVariable String teacherID){
        log.info("Action.getTeacher.start teacherID : {}" ,teacherID);
        var teacherDto = teacherService.getTeacher(teacherID);
        log.info("Action.getTeacher.end teacherID : {}" ,teacherID);
        return teacherDto;
    }

    @PostMapping
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto){
        log.info("Action.saveTeacher.start teacher : {}" , teacherDto);
        teacherService.saveTeacher(teacherDto);
        log.info("Action.saveTeacher.end teacher : {}", teacherDto);
        return teacherDto;
    }

    @DeleteMapping("/{teacherID}")
    public String deleteTeacher(@PathVariable String teacherID){
        log.info("Action.deleteTeacher.start teacherID : {}", teacherID);
        teacherService.deleteTeacher(teacherID);
        log.info("Action.deleteTeacher.end teacherID : {}" , teacherID);
        return teacherID + " teacher has been  deleted";
    }

    @PatchMapping("/{teacherID}/assign/{studentID}")
    public void assignToStudent(@PathVariable String teacherID, @PathVariable Long studentID) {
        log.info("Action.assignToStudent.start teacher : {} | student : {}", teacherID ,studentID);
        teacherService.assignToStudent(teacherID, studentID);
        log.info("Action.assignToStudent.end teacher : {} | student : {}", teacherID ,studentID);
    }
}
