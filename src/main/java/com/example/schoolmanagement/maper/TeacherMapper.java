package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.teacher.TeacherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    List<TeacherDto> mapToDto (List<TeacherEntity> teacherEntities);
    TeacherDto mapToDto (TeacherEntity teacherEntities);

    TeacherEntity mapToEntity(TeacherDto teacherDto);

}
