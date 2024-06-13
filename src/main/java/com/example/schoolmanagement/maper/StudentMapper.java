package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.student.StudentDto;
import com.example.schoolmanagement.model.enums.Mark;
import com.example.schoolmanagement.model.student.StudentWithoutCardDto;
import com.example.schoolmanagement.model.student.StudentWithoutTaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", imports = Mark.class)
public abstract class StudentMapper {


    @Mapping(target = "mark", expression = "java(Mark.getMarkByScore( studentEntity.getScore() ))")
    public abstract StudentDto mapToDto(StudentEntity studentEntity);

    @Mapping(target = "mark", expression = "java(Mark.getMarkByScore( studentEntity.getScore() ))")
    public abstract StudentWithoutCardDto mapToStudentWithoutCardDto(StudentEntity studentEntity);

    public abstract StudentWithoutTaskDto mapToStudentWithoutTaskDto(StudentDto studentDto);
    public abstract StudentWithoutTaskDto mapToStudentWithoutTaskDto(StudentEntity studentEntity);
    public abstract StudentEntity mapToEntity(StudentDto studentDto);
}
