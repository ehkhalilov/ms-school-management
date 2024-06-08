package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "students", source = "students")
    TeacherEntity mapToEntity(TeacherDto teacherDto);

    @Mapping(target = "students", source = "students")
    TeacherDto teacherToTeacherDto(TeacherEntity teacherEntity);
}
