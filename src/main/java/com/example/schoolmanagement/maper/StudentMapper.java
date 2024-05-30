package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract StudentDto mapToDto(StudentEntity studentEntity);
    public abstract StudentEntity mapToEntity(StudentDto studentDto);

}
