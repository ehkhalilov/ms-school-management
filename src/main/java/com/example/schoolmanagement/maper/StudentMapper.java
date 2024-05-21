package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setSurname(studentEntity.getSurname());
        studentDto.setBirthDate(studentEntity.getBirthDate());
        studentDto.setScore(studentEntity.getScore());
        studentDto.setCourse(studentEntity.getCourse());

        return studentDto;
    }
}
