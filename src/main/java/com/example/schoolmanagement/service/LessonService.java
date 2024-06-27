package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.LessonRepository;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.enums.Exceptions;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.mapper.LessonMapper;
import com.example.schoolmanagement.model.get.LessonGetDto;
import com.example.schoolmanagement.model.set.LessonSetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public LessonEntity findById(Long id){
        return lessonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Exceptions.LESSON_NOT_FOUND.name(),
                        String.format(Exceptions.LESSON_NOT_FOUND.getLog(), id)));
    }

    public void saveLesson(LessonSetDto lessonSetDto){
        log.info("ActionLog.saveLesson.start");
        LessonEntity lessonEntity  = lessonMapper.mapToEntity(lessonSetDto);
        lessonRepository.save(lessonEntity);
        log.info("ActionLog.saveLesson.end");
    }

    public List<LessonGetDto> getAllLessons(){
        log.info("ActionLog.getAllLessons.start");
        List<LessonEntity> lessonEntities = lessonRepository.findAll();
        List<LessonGetDto> lessonGetDtos = lessonMapper.mapToDtos(lessonEntities);
        log.info("ActionLog.getAllLessons.end");
        return lessonGetDtos;
    }

    public LessonGetDto getLesson(Long teacherId){
        log.info("ActionLog.getLesson.start teacherId {}", teacherId);
        LessonEntity lessonEntity = findById(teacherId);
        LessonGetDto lessonGetDto = lessonMapper.mapToDto(lessonEntity);
        log.info("ActionLog.getLesson.end teacherId {}", teacherId);
        return lessonGetDto;
    }

    public void deleteLesson(Long lessonId) {
        log.info("ActionLog.deleteLesson.start lessonId {}", lessonId);
        LessonEntity lessonEntity = findById(lessonId);
        for (TeacherEntity teacherEntity : lessonEntity.getTeacherEntities()){
            teacherEntity.getLessonEntities().remove(lessonEntity);
            teacherRepository.save(teacherEntity);
        }
        for (StudentEntity studentEntity : lessonEntity.getStudentEntities()){
            studentEntity.getLessonEntities().remove(lessonEntity);
            studentRepository.save(studentEntity);
        }
        lessonRepository.deleteById(lessonId);
        log.info("ActionLog.deleteLesson.end lessonId {}", lessonId);
    }
}
