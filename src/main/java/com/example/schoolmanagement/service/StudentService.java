package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.mapper.StudentMapper;
import com.example.schoolmanagement.model.get.StudentGetDto;
import com.example.schoolmanagement.model.set.StudentSetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentGetDto> getAllStudents(){
        log.info("ActionLog.getAllStudent.start");
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentGetDto> studentGetDtos =  studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
        log.info("ActionLog.getAllStudent.end");
        return studentGetDtos;
    }

    public StudentGetDto getStudent(Long studentId) throws NotFoundException{
        log.info("ActionLog.getStudent.start studentId {}", studentId);
        StudentEntity studentEntity = findById(studentId);
        StudentGetDto studentGetDto = studentMapper.mapToDto(studentEntity);
        log.info("ActionLog.getStudent.end studentId {}", studentId);
        return studentGetDto;
    }

    public void saveStudent(StudentSetDto studentSetDto) {
        log.info("ActionLog.saveStudent.start");
        StudentEntity studentEntity = studentMapper.mapSaveDtoToEntity(studentSetDto);
        studentRepository.save(studentEntity);
        log.info("ActionLog.saveStudent.end");
    }

    public void deleteStudent(Long studentId) throws NotFoundException{
        log.info("ActionLog.deleteStudent.start");
        studentRepository.deleteById(studentId);
        log.info("ActionLog.getStudent.end studentId {}", studentId);
    }

    public void updateStudent(StudentSetDto studentSetDto, Long studentId) throws NotFoundException{
        log.info("ActionLog.updateStudent.start studentId {}", studentId);
        StudentEntity studentEntity = findById(studentId);
        studentEntity = studentMapper.mapDtoToEntityUpdate(studentSetDto, studentEntity);
        studentRepository.save(studentEntity);
        log.info("ActionLog.updateStudent.end studentId {}", studentId);
    }

    public void graduate(Long studentId) throws NotFoundException{
        log.info("ActionLog.graduate.start studentId {}", studentId);
        StudentEntity studentEntity = findById(studentId);
        studentEntity.setGraduate(!studentEntity.getGraduate());
        studentRepository.save(studentEntity);
        log.info("ActionLog.graduate.end studentId {}", studentId);
    }

    public List<StudentGetDto> getAllStudents(Boolean graduate) {
        log.info("ActionLog.getAllStudents.start graduate {}", graduate);
        List<StudentEntity> studentEntityList = studentRepository.getStudentsByGraduate(graduate);
        List<StudentGetDto> studentGetDtos =  studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
        log.info("ActionLog.getAllStudents.end graduate {}", graduate);
        return studentGetDtos;
    }

    private StudentEntity findById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("STUDENT_NOT_FOUND"));
    }

}
