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

/**
 * @author: nijataghayev
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final StudentRepository studentRepository;

    public List<TeacherDto> getAllTeachers(){
        log.info("ActionLog.getAllTeachers.start");
        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
        List<TeacherDto> teacherDtos = teacherEntityList.stream()
                .map(teacherMapper::mapToDto)
                .toList();
        log.info("ActionLog.getAllTeachers.end");

        return teacherDtos;
    }

    public TeacherDto getTeacher(Long teacherId){
        log.info("ActionLog.getTeacher.start teacherId {}", teacherId);
        var teacherEntity = teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getTeacher.id {} not found", teacherId);
                    return new RuntimeException("TEACHER_NOT_FOUND");
                });
        var teacherDto = teacherMapper.mapToDto(teacherEntity);
        log.info("ActionLog.getTeacher.end teacherId {}", teacherId);

        return teacherDto;
    }

    public void addTeacher(TeacherDto teacherDto) {
        log.debug("ActionLog.addTeacher.start teacher {}", teacherDto);
        var teacherEntity = teacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacherEntity);
        log.debug("ActionLog.addTeacher.end teacher {}", teacherDto);
    }

    public void assigneeStudentToTeacher(Long teacherId, Long studentId) {
        var student = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("ActionLog.assigneeStudentToTeacher.id {} not found", studentId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        var teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    log.error("ActionLog.assigneeStudentToTeacher.id {} not found", teacherId);
                    return new RuntimeException("TEACHER_NOT_FOUND");
                });

        var list = teacher.getStudents();
        list.add(student);
        teacher.setStudents(list);
        student.getTeachers().add(teacher);
        teacherRepository.save(teacher);
        studentRepository.save(student);
    }
}
