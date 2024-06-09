package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherDto;
import org.mapstruct.Mapper;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDto mapToDto(TeacherEntity teacherEntity);

    TeacherEntity mapToEntity(TeacherDto teacherDto);
}
