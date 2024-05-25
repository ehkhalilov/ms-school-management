package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto studentToStudentDto(StudentEntity studentEntity);
    StudentEntity studentDtoToStudentEntity(StudentDto studentDto);
}
