package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.enums.Grade;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
//    public final StudentEntity studentEntity;
    @Mapping(target = "score",source = "studentEntity",qualifiedByName = "scoreToGrade")
    public abstract StudentDto mapToDto(StudentEntity studentEntity);

    @Named("scoreToGrade")
    public Grade scoreToGrade(StudentEntity studentEntity){

        Double score = studentEntity.getScore();

        if(score>90){
            return Grade.A;
        } else if (score>80 ) {
            return Grade.B;
        } else if (score>70 ) {
            return Grade.C;
        } else if (score>60 ) {
            return Grade.D;
        } else {
            return Grade.E;
        }
    }
    public abstract StudentEntity dtoToMap(StudentSaveDto studentSaveDto);
}
