package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final StudentRepository studentRepository;

    public StudentMapper(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setSurname(studentEntity.getSurname());
        studentDto.setScore(studentEntity.getScore());
        studentDto.setBirthDate(studentEntity.getBirthDate());
        studentDto.setCourse(studentEntity.getCourse());

        return studentDto;
    }
    public StudentEntity mapToEntity(StudentDto studentDto) {

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(studentDto.getId());
        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setScore(studentDto.getScore());
        studentEntity.setBirthDate(studentDto.getBirthDate());
        studentEntity.setCourse(studentDto.getCourse());

        return studentEntity;
    }
}
