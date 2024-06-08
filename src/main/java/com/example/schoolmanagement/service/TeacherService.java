package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.maper.TeacherMapper;
import com.example.schoolmanagement.model.TeacherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final StudentRepository studentRepository;

    public List<TeacherDto> getAllTeachers() {
        log.info("ActionLog.getAllTeachers.starts");
        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
        var teacherDtos = teacherEntityList.stream()
                .map(teacherMapper::teacherToTeacherDto)
                .toList();
        log.info("ActionLog.getAllTeachers.ends");

        return teacherDtos;
    }

    public TeacherDto getTeacher(Long teacherId) {
        log.info("ActionLog.getTeacher.starts teacherId {}", teacherId);
        var teacherEntity = teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getTeacher.teacherNotFound {}", teacherId);
                    return new RuntimeException("Teacher_NOT_FOUND");
                });
        var teacherDto = teacherMapper.teacherToTeacherDto(teacherEntity);
        log.info("ActionLog.getTeacher.ends teacherId {}", teacherId);
        return teacherDto;
    }

    public void addTeacher(TeacherDto teacherDto) {
        var teacherEntity = teacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacherEntity);
    }

    public void assignStudentToTeacher(Long teacherID, Long studentID) {
        var student = studentRepository.findById(studentID).orElseThrow();
        var teacher = teacherRepository.findById(teacherID).orElseThrow();
        student.getTeachers().add(teacher);
        studentRepository.save(student);
    }
}
