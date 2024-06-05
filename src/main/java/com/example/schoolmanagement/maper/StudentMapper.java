package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.enums.Mark;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithMarkDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {Mark.class})
public abstract class  StudentMapper {

    public abstract StudentDto mapToDto(StudentEntity studentEntity);

    @Mapping(target = "mark", expression = "java(Mark.getMark(studentEntity.getScore()))")
    public abstract StudentWithMarkDto toDto(StudentEntity studentEntity);

    public abstract StudentEntity mapToEntity(StudentDto studentDto);
}
