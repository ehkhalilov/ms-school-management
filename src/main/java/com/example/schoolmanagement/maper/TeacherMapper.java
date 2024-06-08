package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "students", source = "students")
    TeacherEntity mapToEntity(TeacherDto teacherDto);

    @Mapping(target = "students", source = "students")
    TeacherDto teacherToTeacherDto(TeacherEntity teacherEntity);
}
