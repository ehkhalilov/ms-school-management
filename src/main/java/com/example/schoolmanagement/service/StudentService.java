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

    public StudentDto getStudent(Long customerId) {
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        return studentMapper.mapToDto(studentEntity);
    }

    public List<StudentDto> filterForGraduate(){

        List<StudentEntity> studentEntityList = studentRepository.findAll().stream().filter((i)->!i.isGraduate()).toList();

        List<StudentDto> studentDtoList = studentEntityList.stream()
                .map(studentMapper::mapToDto).toList();

        return studentDtoList;
    }

    public void saveStudent(StudentDto studentDto) {

//        studentDto.stream()
//                .map(studentMapper::mapToDto)
//                .toList();

//        studentDto
        StudentEntity studentEntity=studentMapper.dtoToMap(studentDto);

        studentRepository.save(studentEntity);

    }

    public void deleteStudent(Long customerId) {

        studentRepository.deleteById(customerId);

    }

    public void updateStudent(StudentDto studentDto, Integer customerId) {

    }


}
