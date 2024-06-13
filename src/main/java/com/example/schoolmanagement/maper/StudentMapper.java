package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentFullInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract StudentDto mapToDto(StudentEntity studentEntity);
    public abstract StudentEntity mapToEntity(StudentDto studentDto);
    public abstract StudentEntity mapToEntity(StudentFullInfoDto studentFullInfoDto);

}
