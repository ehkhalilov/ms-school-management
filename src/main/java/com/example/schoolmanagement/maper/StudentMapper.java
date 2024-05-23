package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName() + " " + studentEntity.getSurname());
        studentDto.setScore(studentEntity.getScore());

        return studentDto;
    }

    public StudentEntity mapToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setScore(studentDto.getScore());
        studentEntity.setBirthDate(studentDto.getBirthDate());
        studentEntity.setCourse(studentDto.getCourse());
        studentEntity.setGraduated(studentDto.getGraduated());

        return studentEntity;
    }
}
