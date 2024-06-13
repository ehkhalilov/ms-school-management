package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.maper.TeacherMapper;
import com.example.schoolmanagement.model.TeacherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    private TeacherEntity getTeacherById(Long teacherId) {
        return teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getTeacherById id={}", teacherId);
                    return new RuntimeException("TEACHER_NOT_FOUND");}
                );
    }

    public List<TeacherDto> getAllTeachers() {
        log.info("ActionLog.getAllTeachers.start");

        List<TeacherDto> teacherDtoList = teacherMapper.
                        mapToDtoList(teacherRepository.findAll());

        log.info("ActionLog.getAllTeachers.end");

        return teacherDtoList;
    }

    public TeacherDto getTeacher(Long teacherId) {
        log.info("ActionLog.getTeacher.start teacherId={}", teacherId);

        TeacherDto teacherDto = teacherMapper.mapToDto(getTeacherById(teacherId));

        log.info("ActionLog.getTeacher.end teacherId={}", teacherId);

        return teacherDto;
    }

    public void saveTeacher(TeacherDto teacherDto) {
        log.info("ActionLog.saveTeacher.start teacherDto={}", teacherDto);

        TeacherEntity teacherEntity = teacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacherEntity);

        log.info("ActionLog.saveTeacher.end teacherDto={}", teacherDto);
    }
    public void deleteTeacher(Long teacherId) {
        log.info("ActionLog.deleteTeacher.start teacherId={}", teacherId);

        teacherRepository.deleteById(teacherId);

        log.info("ActionLog.deleteTeacher.end teacherId={}", teacherId);
    }

}
