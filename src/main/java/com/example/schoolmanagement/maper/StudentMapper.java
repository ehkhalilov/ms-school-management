package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentGetDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentGetDto mapToDto(StudentEntity studentEntity) {
        StudentGetDto studentGetDto = new StudentGetDto();

        studentGetDto.setId(studentEntity.getId());
        studentGetDto.setName(studentEntity.getName());
        studentGetDto.setSurname(studentEntity.getSurname());
        studentGetDto.setBirthDate(studentEntity.getBirthDate());
        studentGetDto.setGraduate(studentEntity.getGraduate());

        return studentGetDto;
    }
    public StudentEntity mapSaveDtoToEntity(StudentSaveDto studentSaveDto) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentSaveDto.getName());
        studentEntity.setSurname(studentSaveDto.getSurname());
        studentEntity.setFatherName(studentSaveDto.getFatherName());
        studentEntity.setBirthDate(studentSaveDto.getBirthDate());
        studentEntity.setGraduate(false);

        return studentEntity;
    }
}
