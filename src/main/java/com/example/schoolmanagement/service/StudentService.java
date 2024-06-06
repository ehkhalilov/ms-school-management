package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.repository.StudentRepository;
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
        log.debug("ActionLog.getStudent.start customerId {}", customerId);
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
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

    public void deleteStudent(Integer customerId) {

    }

    public void updateStudent(StudentDto studentDto, Integer customerId) {
    }


}
