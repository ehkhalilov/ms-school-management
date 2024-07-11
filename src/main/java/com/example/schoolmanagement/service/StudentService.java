package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.exception.ValidationException;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.schoolmanagement.enums.Exceptions.STUDENT_NOT_FOUND;

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

    public StudentDto getStudent(Long studentId) {
        log.debug("ActionLog.getStudent.start studentId {}", studentId);
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        STUDENT_NOT_FOUND.name(),
                        String.format(STUDENT_NOT_FOUND.getMessage(), studentId)
                ));
        var studentDto = studentMapper.mapToDto(studentEntity);
        log.info("ActionLog.getStudent.end customerId {}", studentId);
        return studentDto;
    }

    public void saveStudent(StudentDto studentDto) {
        log.info("ActionLog.saveStudent.start student {}", studentDto);
        if (studentDto.getScore() < 50) {
            throw new ValidationException("AGE_MUST_BE_MORE_THAN_50",
                    String.format("ActionLog.saveStudent.error student age must be more than 50 bu now is %s ",
                            studentDto.getScore()));
        }
        var studentEntity = studentMapper.mapToEntity(studentDto);
        studentRepository.save(studentEntity);
        log.info("ActionLog.saveStudent.end student {}", studentDto);
    }

    public void deleteStudent(Integer studentId) {
        var teacherId = 1L;
        var student = studentRepository.findById(studentId).orElseThrow();
        var teachers = student.getTeachers();
        teachers.removeIf(it -> it.getId() == teacherId);
        student.setTeachers(teachers);
        studentRepository.save(student);
    }

    public void updateStudent(StudentDto studentDto, Integer customerId) {
    }


}
