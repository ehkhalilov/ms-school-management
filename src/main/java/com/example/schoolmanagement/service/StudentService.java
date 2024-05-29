package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithMarkDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentWithMarkDto> getAllStudents() {
        log.info("ActionLog.getAllStudent.start");
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentWithMarkDto> studentWithMarkDtos = studentEntityList.stream()
                .map(studentMapper::toDto)
                .toList();
        log.info("ActionLog.getAllStudent.end");

        return studentWithMarkDtos;
    }

    public StudentWithMarkDto getStudent(Long customerId) {
        log.info("ActionLog.getStudent.start customerId {}", customerId);
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
        var studentWithMarkDto= studentMapper.toDto(studentEntity);
        log.info("ActionLog.getStudent.end customerId {}", customerId);

        return studentWithMarkDto;
    }

    public void saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        studentEntity.setGraduated(false);
        studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
        studentRepository.delete(studentEntity);
    }

    public void updateStudent(StudentDto studentDto, Long customerId) {
        StudentEntity existingStudent = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.updateStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        StudentEntity updatedStudent = studentMapper.mapToEntity(studentDto);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setScore(updatedStudent.getScore());
        existingStudent.setBirthDate(updatedStudent.getBirthDate());
        existingStudent.setCourse(updatedStudent.getCourse());

        studentRepository.save(existingStudent);
    }

    public void graduatedStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.graduatedStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        studentEntity.setGraduated(true);
        studentRepository.save(studentEntity);
    }
}
