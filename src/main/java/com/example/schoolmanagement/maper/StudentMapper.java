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

        String name = studentDto.getName();
        if (name != null) {
            String[] parts = name.split(" ");
            studentEntity.setName(parts[0]);
            if (parts.length > 1) {
                studentEntity.setSurname(parts[1]);
            }
        }
        studentEntity.setScore(studentDto.getScore());

        return studentEntity;
    }
}
