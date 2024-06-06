package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    @Mapping(target = "name", expression = "java(studentEntity.getName() + ' ' + studentEntity.getSurname())")
    public abstract StudentDto mapToDto(StudentEntity studentEntity);
    
    public abstract StudentEntity mapToEntity(StudentDto studentDto);
}
