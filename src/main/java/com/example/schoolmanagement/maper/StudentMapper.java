package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.enums.Score;
import com.example.schoolmanagement.model.StudentGetDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;



@Mapper(componentModel = "spring", imports = {Score.class})
public abstract class StudentMapper {

    @Mapping(target = "score", expression = "java(Score.getScore(studentEntity.getScore()))")
    public abstract StudentGetDto mapToDto(StudentEntity studentEntity);

    @Mapping(target = "graduate", constant = "false")
    public abstract StudentEntity mapSaveDtoToEntity(StudentSaveDto studentSaveDto);

    public abstract StudentEntity mapDtoToEntityUpdate(
            StudentSaveDto studentSaveDto, @MappingTarget StudentEntity studentEntity);

}
