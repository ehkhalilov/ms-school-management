package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeacherMapper {
    abstract public TeacherEntity mapToEntity(TeacherDto teacherDto);
    abstract public TeacherDto mapToDto(TeacherEntity teacherEntity);
    abstract public List<TeacherDto> mapToDtoList(List<TeacherEntity> teacherEntities);
}
