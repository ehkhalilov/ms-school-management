package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.LessonRepository;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.enums.Exceptions;
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
    private final LessonService lessonService;
    private final LessonRepository lessonRepository;

    public StudentEntity findById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Exceptions.STUDENT_NOT_FOUND.name(),
                        String.format(Exceptions.STUDENT_NOT_FOUND.getLog(), id)
                ));
    }

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
        log.info("ActionLog.deleteStudent.start teacherId {}", studentId);
        StudentEntity studentEntity = findById(studentId);
        for (LessonEntity lessonEntity : studentEntity.getLessonEntities()){
            lessonEntity.getStudentEntities().remove(studentEntity);
            lessonRepository.save(lessonEntity);
        }
        studentRepository.deleteById(studentId);
        log.info("ActionLog.deleteStudent.end studentId {}", studentId);
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

    public List<StudentGetDto> getStudentsByGraduate(Boolean graduate) {
        log.info("ActionLog.getStudentsByGraduate.start graduate {}", graduate);
        List<StudentEntity> studentEntities = studentRepository.getStudentsByGraduate(graduate);
        List<StudentGetDto> studentGetDtos =  studentMapper.mapToDtos(studentEntities);
        log.info("ActionLog.getStudentsByGraduate.end graduate {}", graduate);
        return studentGetDtos;
    }

    public void assignLesson(Long studentId, Long lessonId) {
        log.info("ActionLog.assignLesson.start studentId {}, lessonId {}", studentId, lessonId);
        StudentEntity studentEntity = findById(studentId);
        LessonEntity lessonEntity = lessonService.findById(lessonId);
        if (!studentEntity.getLessonEntities().contains(lessonEntity)) {
            studentEntity.getLessonEntities().add(lessonEntity);
            lessonEntity.getStudentEntities().add(studentEntity);

            studentRepository.save(studentEntity);
            lessonRepository.save(lessonEntity);
        }
        log.info("ActionLog.assignLesson.end studentId {}, lessonId {}", studentId, lessonId);
    }

    public void removeLessonFromStudent(Long studentId, Long lessonId) {
        log.info("ActionLog.removeLessonFromStudent.start studentId {}, lessonId {}", studentId, lessonId);
        StudentEntity studentEntity = findById(studentId);
        LessonEntity lessonEntity = lessonService.findById(lessonId);
        studentEntity.getLessonEntities().remove(lessonEntity);
        studentRepository.save(studentEntity);
        log.info("ActionLog.removeLessonFromStudent.end studentId {}, lessonId {}", studentId, lessonId);
    }

}
