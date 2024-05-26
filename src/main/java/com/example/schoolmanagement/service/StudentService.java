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
        List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();
        return studentEntityList.stream()
                .map(studentMapper::mapToDTO)
                .toList();
    }

    public StudentDto getStudent(Long studentId) {
        StudentEntity studentInfo = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT NOT FOUND"));

        return studentMapper.mapToDTO(studentInfo);
    }

    public void saveStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.mapToEntity(studentDto));
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        Long dataId = (studentId != null) ? studentId : studentDto.getId();
        studentRepository.deleteById(dataId);
        StudentEntity studentEntityUpdated = studentMapper.mapToEntity(studentDto);
        studentRepository.save(studentEntityUpdated);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
