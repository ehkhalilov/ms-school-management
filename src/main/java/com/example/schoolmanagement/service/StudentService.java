package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();

        return studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
    }

    public StudentDto getStudent(Long studentId) {
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        return studentMapper.mapToDto(studentEntity);
    }

    public void saveStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.mapToEntity(studentDto));
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        studentRepository.setStudentInfoById(studentDto.getName(),studentDto.getSurname(),
                studentDto.getScore(), studentDto.getBirthDate(),
                studentDto.getCourse(), studentId);
    }


}
