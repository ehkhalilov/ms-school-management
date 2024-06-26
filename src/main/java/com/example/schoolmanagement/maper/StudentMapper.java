package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto mapToDto(StudentEntity studentEntity);
    
    StudentEntity mapToEntity(StudentDto studentDto);
}
