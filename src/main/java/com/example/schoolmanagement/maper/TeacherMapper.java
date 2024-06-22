package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.model.TeacherRequestDto;
import com.example.schoolmanagement.model.TeacherResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherEntity mapToEntity(TeacherRequestDto teacherRequestDto);
    TeacherEntity mapToEntity(TeacherResponseDto teacherResponseDto);
    TeacherResponseDto mapToRespDto(TeacherEntity teacherEntity);
    TeacherRequestDto mapToReqDto(TeacherEntity  teacherEntity);

}
