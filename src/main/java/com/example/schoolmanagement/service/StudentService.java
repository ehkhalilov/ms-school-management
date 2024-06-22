package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.exceptions.NotFound;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
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

    public List<StudentDto> getAllStudents() {
        log.info("ActionLog.getAllStudents.start");
        var studentEntityList = studentRepository.findAll();
        var studentDtos = studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
        log.info("ActionLog.getAllStudents.end");
        return studentDtos;
    }

    public StudentDto getStudent(Long customerId) {
        log.info("ActionLog.getStudent.start customerId {}", customerId);
        var studentEntity =findStudent(customerId);
        var studentDto = studentMapper.mapToDto(studentEntity);
        log.info("ActionLog.getStudent.end customerId {}", customerId);
        return studentDto;
    }

    public void saveStudent(StudentDto studentDto) {
        log.info("ActionLog.saveStudent.start student {}", studentDto);
        var studentEntity = studentMapper.mapToEntity(studentDto);
        studentRepository.save(studentEntity);
        log.info("ActionLog.saveStudent.end student {}", studentDto);
    }

    public StudentDto deleteStudent(Long customerId) {
        log.info("ActionLog.deleteStudent.start student {}",customerId);

        StudentEntity studentEntity = findStudent(customerId);
        StudentDto studentDto = studentMapper.mapToDto(studentEntity);
        studentRepository.deleteById(customerId);

        log.info("ActionLog.deleteStudent.end student {}",customerId);
        return studentDto;
    }

    public void updateStudent(StudentDto studentDto, Long customerId) {
        log.info("ActionLog.updateStudent.start student {}",customerId);

        StudentEntity studentEntity = findStudent(customerId);

        if(studentDto.getName()!=null){
            studentEntity.setName(studentDto.getName());
        }
        if(studentDto.getScore()!=null){
            studentEntity.setScore(studentDto.getScore());
        }

        studentRepository.save(studentEntity);
        log.info("ActionLog.updateStudent.end student {}",customerId);
    }

    private StudentEntity findStudent(Long customerId){
        StudentEntity studentEntity = studentRepository.findById(customerId).
                orElseThrow(()->new NotFound("STUDENT_NOT_FOUND","Error ActionLog.findStudent student {"+customerId+"}"));

        return studentEntity;
    }

}
