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
        List<StudentEntity> studentEntityList = studentRepository.findByIsGraduatedFalse();

        return studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
    }

    public StudentDto getStudent(Long customerId) {
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        return studentMapper.mapToDto(studentEntity);
    }

    public void saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        studentEntity.setGraduated(false);
        studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        studentRepository.delete(studentEntity);
    }

    public void updateStudent(StudentDto studentDto, Long customerId) {
        StudentEntity existingStudent = studentRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        StudentEntity updatedStudent = studentMapper.mapToEntity(studentDto);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setScore(updatedStudent.getScore());
        existingStudent.setBirthDate(updatedStudent.getBirthDate());
        existingStudent.setCourse(updatedStudent.getCourse());

        studentRepository.save(existingStudent);
    }

    public void gruatedStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        studentEntity.setGraduated(true);
        studentRepository.save(studentEntity);
    }
}
