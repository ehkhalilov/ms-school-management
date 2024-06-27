package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.enums.Score;
import com.example.schoolmanagement.model.get.CardGetDto;
import com.example.schoolmanagement.model.get.StudentGetDto;
import com.example.schoolmanagement.model.set.StudentSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring", imports = {Score.class})
public abstract class StudentMapper {

    @Mapping(target = "score", expression = "java(Score.getScore(studentEntity.getScore()))")
    @Mapping(target = "card", source = "cardEntity")
    public abstract StudentGetDto mapToDto(StudentEntity studentEntity);

    @Mapping(target = "graduate", constant = "false")
    @Mapping(target = "cardEntity", source = "cardSetDto")
    public abstract StudentEntity mapSaveDtoToEntity(StudentSetDto studentSetDto);

    public abstract StudentEntity mapDtoToEntityUpdate(
            StudentSetDto studentSetDto, @MappingTarget StudentEntity studentEntity);

    public abstract CardGetDto.Student mapToStudent(StudentGetDto studentGetDto);

    public abstract List<StudentGetDto> mapToDtos(List<StudentEntity> studentEntities);
}
