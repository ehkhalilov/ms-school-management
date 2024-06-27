package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.LessonRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.enums.Exceptions;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.mapper.TeacherMapper;
import com.example.schoolmanagement.model.get.TeacherGetDto;
import com.example.schoolmanagement.model.set.TeacherSetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final LessonRepository lessonRepository;
    private final LessonService lessonService;

    private TeacherEntity findById(Long id){
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Exceptions.TEACHER_NOT_FOUND.name(),
                        String.format(Exceptions.TEACHER_NOT_FOUND.getLog(), id)
                ));
    }

    public void saveTeacher(TeacherSetDto teacherSetDto){
        log.info("ActionLog.saveTeacher.start");
        TeacherEntity teacherEntity = teacherMapper.mapToEntity(teacherSetDto);
        teacherRepository.save(teacherEntity);
        log.info("ActionLog.saveTeacher.end");
    }

    public List<TeacherGetDto> getAllTeachers(){
        log.info("ActionLog.getAllTeachers.start");
        List<TeacherEntity> teacherEntities = teacherRepository.findAll();
        List<TeacherGetDto> teacherGetDtos = teacherMapper.mapToDtos(teacherEntities);
        log.info("ActionLog.getAllTeachers.end");
        return teacherGetDtos;
    }

    public TeacherGetDto getTeacher(Long teacherId){
        log.info("ActionLog.getTeacher.start teacherId {}", teacherId);
        TeacherEntity teacherEntity = findById(teacherId);
        TeacherGetDto teacherGetDto = teacherMapper.mapToDto(teacherEntity);
        log.info("ActionLog.getTeacher.end teacherId {}", teacherId);
        return teacherGetDto;
    }

    public void assignLesson(Long teacherId, Long lessonId) {
        log.info("ActionLog.assignLesson.start teacherId {}, lessonId {}", teacherId, lessonId);
        TeacherEntity teacherEntity = findById(teacherId);
        LessonEntity lessonEntity = lessonService.findById(lessonId);
        if (!teacherEntity.getLessonEntities().contains(lessonEntity)) {
            teacherEntity.getLessonEntities().add(lessonEntity);
            lessonEntity.getTeacherEntities().add(teacherEntity);

            teacherRepository.save(teacherEntity);
            lessonRepository.save(lessonEntity);
        }
        log.info("ActionLog.assignLesson.end teacherId {}, lessonId {}", teacherId, lessonId);
    }

    public void deleteTeacher(Long teacherId){
        log.info("ActionLog.deleteTeacher.start teacherId {}", teacherId);
        TeacherEntity teacherEntity = findById(teacherId);
        for (LessonEntity lessonEntity : teacherEntity.getLessonEntities()){
            lessonEntity.getTeacherEntities().remove(teacherEntity);
            lessonRepository.save(lessonEntity);
        }
        teacherRepository.deleteById(teacherId);
        log.info("ActionLog.deleteTeacher.end teacherId {}", teacherId);
    }

    public void removeLessonFromTeacher(Long teacherId, Long lessonId) {
        log.info("ActionLog.removeLessonFromTeacher.start teacherId {}, lessonId {}", teacherId, lessonId);
        TeacherEntity teacherEntity = findById(teacherId);
        LessonEntity lessonEntity = lessonService.findById(lessonId);
        teacherEntity.getLessonEntities().remove(lessonEntity);
        teacherRepository.save(teacherEntity);
        log.info("ActionLog.removeLessonFromTeacher.end teacherId {}, lessonId {}", teacherId, lessonId);
    }

}
