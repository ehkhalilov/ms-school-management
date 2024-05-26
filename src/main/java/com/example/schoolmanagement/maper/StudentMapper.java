package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.model.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDto mapToDTO(StudentEntity studentEntity) {
        StudentDto studentsDTO = new StudentDto();

        studentsDTO.setId(studentEntity.getId());
        studentsDTO.setName(studentEntity.getName());
        studentsDTO.setScore(studentEntity.getScore());
        studentsDTO.setBirthDate(studentEntity.getBirthDate());
        studentsDTO.setCourse(studentEntity.getCourse());
        studentsDTO.setGraduated(studentEntity.getIsGraduated());

        return studentsDTO;
    }

    public StudentEntity mapToEntity(StudentDto studentsDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentsDTO.getId());
        studentEntity.setName(studentsDTO.getName());
        studentEntity.setScore(studentsDTO.getScore());
        studentEntity.setBirthDate(studentsDTO.getBirthDate());
        studentEntity.setCourse(studentsDTO.getCourse());
        studentEntity.setIsGraduated(studentsDTO.getGraduated());

        return studentEntity;
    }
}
