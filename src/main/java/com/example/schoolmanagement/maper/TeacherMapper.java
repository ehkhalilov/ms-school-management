package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherEntity mapToEntity(TeacherDto teacherDto);

    TeacherDto mapToDto(TeacherEntity teacherEntity);
}
