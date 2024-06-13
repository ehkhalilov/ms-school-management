package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.maper.TeacherMapper;
import com.example.schoolmanagement.model.teacher.TeacherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    private final StudentRepository studentRepository;

    public List<TeacherDto> getAllTeachers() {
        return teacherMapper.mapToDto(teacherRepository.findAll());
    }

    public TeacherDto getTeacher(String teacherID){
        return teacherMapper.mapToDto(
                teacherRepository.findById(teacherID).
                        orElseThrow(()-> new RuntimeException("TEACHER_NOT_FOUND"))
        );
    }

    public void saveTeacher(TeacherDto teacherDto) {
        var teacherEntity = teacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacherEntity);
    }

    public void deleteTeacher(String teacherID){
        var teacher = teacherRepository.findById(teacherID).orElseThrow(() -> new RuntimeException("TEACHER_NOT_FOUND"));
        for (StudentEntity std : teacher.getStudents()){
            std.getTeachers().remove(teacher);
            studentRepository.save(std);
        }
        teacher.getStudents().clear();
        teacherRepository.save(teacher);
        teacherRepository.deleteById(teacherID);
    }

    public void assignToStudent(String teacherID , Long studentID){
        var studentEntity = studentRepository.findById(studentID)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        var teacherEntity = teacherRepository.findById(teacherID)
                .orElseThrow(() -> new RuntimeException("TEACHER_NOT_FOUND"));
        studentEntity.getTeachers().add(teacherEntity);
        studentRepository.save(studentEntity);
    }
}