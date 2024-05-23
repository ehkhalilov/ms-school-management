package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(studentEntity.getStudentid());
        studentDto.setName(studentEntity.getName() + " " + studentEntity.getSurname());


        return studentDto;
    }

    public StudentEntity dtoToMap(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setStudentid(studentDto.getStudentId());

        return studentEntity;

    }
}
