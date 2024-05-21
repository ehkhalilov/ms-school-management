package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void saveStudent(StudentDto studentDto) {
        System.out.println(studentDto);
        if( studentDto.getName()==null || studentDto.getSurname()==null ){
            // I know it mustn't be like that )
            throw new RuntimeException("Name and Surname required");
        }
        StudentEntity thisStudent = new StudentEntity(
                studentDto.getName(),
                studentDto.getSurname(),
                studentDto.getBirthDate(),
                studentDto.getScore(),
                studentDto.getCourse()
        );
        System.out.println(thisStudent);
        studentRepository.save(thisStudent);
    }

    public void deleteStudent(Long customerId) {
        studentRepository.deleteById(customerId);
    }

    public void updateStudent(StudentDto studentDto, Integer customerId) {
    }


}
