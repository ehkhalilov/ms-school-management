package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.LessonRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
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

    private TeacherEntity findById(Long id){
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TEACHER_NOT_FOUND"));
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
        List<TeacherGetDto> teacherGetDtos = teacherEntities.stream().map(teacherMapper::mapToDto).toList();
        log.info("ActionLog.getAllTeachers.end");
        return teacherGetDtos;
    }

    public TeacherGetDto getTeacher(Long teacherId){
        log.info("ActionLog.getTeacher.start");
        TeacherEntity teacherEntity = findById(teacherId);
        TeacherGetDto teacherGetDto = teacherMapper.mapToDto(teacherEntity);
        log.info("ActionLog.getTeacher.end");
        return teacherGetDto;
    }

    public void assignLesson(Long teacherId, Long lessonId) {
        log.info("ActionLog.assignLesson.start");
        TeacherEntity teacherEntity = findById(teacherId);
        LessonEntity lessonEntity = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new NotFoundException("LESSON_NOT_FOUND"));
        if (!teacherEntity.getLessonEntities().contains(lessonEntity)) {
            teacherEntity.getLessonEntities().add(lessonEntity);
            lessonEntity.getTeacherEntities().add(teacherEntity);

            teacherRepository.save(teacherEntity);
            lessonRepository.save(lessonEntity);
        }
        log.info("ActionLog.assignLesson.end");
    }

    public void deleteTeacher(Long teacherId){
        log.info("ActionLog.deleteTeacher.start");
        TeacherEntity teacherEntity = findById(teacherId);
        for (LessonEntity lessonEntity : teacherEntity.getLessonEntities()){
            lessonEntity.getTeacherEntities().remove(teacherEntity);
            lessonRepository.save(lessonEntity);
        }
        teacherRepository.deleteById(teacherId);
        log.info("ActionLog.deleteTeacher.end");
    }
}
