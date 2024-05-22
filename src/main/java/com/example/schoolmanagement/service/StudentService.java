package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentGetDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentGetDto> getAllStudents() throws NotFoundException{
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if(studentEntityList.isEmpty()) throw new NotFoundException("Students_NOT_FOUND");
        return studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();
    }

    public StudentGetDto getStudent(Long studentId) throws NotFoundException{
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundException("STUDENT_NOT_FOUND"));

        return studentMapper.mapToDto(studentEntity);
    }

    public void saveStudent(StudentSaveDto studentSaveDto) {
        StudentEntity studentEntity = studentMapper.mapSaveDtoToEntity(studentSaveDto);
        studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long studentId) throws NotFoundException{
        studentRepository.findById(studentId).orElseThrow(()-> new NotFoundException("STUDENT_NOT_FOUND"));
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(StudentSaveDto studentSaveDto, Long studentId) throws NotFoundException{
        StudentEntity studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() ->new NotFoundException("STUDENT_NOT_FOUND"));

        studentEntity.setName(studentSaveDto.getName());
        studentEntity.setSurname(studentSaveDto.getSurname());
        studentEntity.setFatherName(studentSaveDto.getFatherName());
        studentEntity.setBirthDate(studentSaveDto.getBirthDate());

        studentRepository.save(studentEntity);
    }


}
