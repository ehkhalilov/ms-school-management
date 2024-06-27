package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.model.get.LessonGetDto;
import com.example.schoolmanagement.model.set.LessonSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public abstract class LessonMapper {

    public abstract LessonEntity mapToEntity(LessonSetDto lessonSetDto);

    @Mapping(target = "teacherGetDtos", source = "teacherEntities")
    @Mapping(target = "studentGetDtos", source = "studentEntities")
    public abstract LessonGetDto mapToDto(LessonEntity lessonEntity);

    public abstract List<LessonGetDto> mapToDtos(List<LessonEntity> lessonEntities);
}
