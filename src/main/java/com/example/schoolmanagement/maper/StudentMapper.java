package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.maper.qualifier.StudentQualifier;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithGradeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = StudentQualifier.class)
public interface StudentMapper {
    @Mapping(target = "grade", source = "score", qualifiedByName = "mapScoreToGrade")
    StudentWithGradeDto toDto(StudentEntity studentEntity);


    StudentDto studentToStudentDto(StudentEntity studentEntity);

    StudentEntity studentDtoToStudentEntity(StudentDto studentDto);
}
