package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.enums.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", imports = Mark.class)
public abstract class StudentMapper {


    @Mapping(target = "mark", expression = "java(Mark.getMarkByScore( studentEntity.getScore() ))")
//    @Mapping(target = "mark", ignore = true)
    public abstract StudentDto mapToDto(StudentEntity studentEntity);

    public abstract StudentEntity mapToEntity(StudentDto studentDto);
}
