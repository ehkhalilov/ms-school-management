package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import com.example.schoolmanagement.model.get.LessonGetDto;
import com.example.schoolmanagement.model.set.LessonSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class LessonMapper {

    public abstract LessonEntity mapToEntity(LessonSetDto lessonSetDto);

    @Mapping(target = "teacherGetDtos", source = "teacherEntities")
    public abstract LessonGetDto mapToDto(LessonEntity lessonEntity);
}
