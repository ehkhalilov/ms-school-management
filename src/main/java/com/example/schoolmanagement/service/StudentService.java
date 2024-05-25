package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.Grade;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithGradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return studentEntityList.stream()
                .map(studentMapper::studentToStudentDto)
                .toList();
    }

    public StudentDto getStudent(Long studentId) {
        var studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        return studentMapper.studentToStudentDto(studentEntity);
    }



    public void saveStudent(StudentDto studentDto) {
        try {
            StudentEntity studentEntity = studentMapper.studentDtoToStudentEntity(studentDto);
            studentRepository.save(studentEntity);
        } catch (Exception e) {
            logger.error("Error saving student: ", e);
            throw new RuntimeException("Error saving student", e);
        }
    }

    public void deleteStudent(Long studentId) {
        logger.info("Deleting student with ID: {}", studentId);
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        logger.info("Updating student with ID: {}", studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setScore(studentDto.getScore());
        studentEntity.setBirthDate(studentDto.getBirthDate());
        studentEntity.setCourse(studentDto.getCourse());
        studentRepository.save(studentEntity);
    }

    public Grade getStudentGrade(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        return Grade.fromScore(studentEntity.getScore());
    }

    public StudentWithGradeDto getStudentWithGrade(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
//        Grade grade = Grade.fromScore(studentEntity.getScore());
//        return new StudentWithGradeDto(
//                studentEntity.getId(),
//                studentEntity.getName(),
//                studentEntity.getSurname(),
//                studentEntity.getBirthDate(),
//                studentEntity.getScore(),
//                studentEntity.getCourse(),
//                grade
//        );
        return studentMapper.toDto(studentEntity);
    }


}
