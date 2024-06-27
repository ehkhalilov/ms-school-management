package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.get.TeacherGetDto;
import com.example.schoolmanagement.model.set.TeacherSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeacherMapper {

    @Mapping(target = "lessonGetDtos", source = "lessonEntities")
    public abstract TeacherGetDto mapToDto(TeacherEntity teacherEntity);

    public abstract TeacherEntity mapToEntity(TeacherSetDto teacherEntity);

    public abstract List<TeacherGetDto> mapToDtos(List<TeacherEntity> teacherEntities);
}
