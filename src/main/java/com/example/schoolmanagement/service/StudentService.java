package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentSaveDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getAllStudents() {
       log.info("ActionLog.getAllStudents.start");
        List<StudentEntity> studentEntityList = studentRepository.findAll();

        var studentDtoList = studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .toList();

        log.info("ActionLog.getAllStudents.end");

        return studentDtoList;
    }

    public StudentDto getStudent(Long customerId) {
        log.info("ActionLog.getStudent.start customerId{}", customerId);
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        log.info("ActionLog.getStudent.end customerId{}", customerId);

        return studentMapper.mapToDto(studentEntity);
    }

    public List<StudentDto> filterForGraduate(){

        log.info("ActionLog.filterForGraduate.start");

        List<StudentEntity> studentEntityList = studentRepository.findAll().stream().filter((i)->!i.getIsGraduate()).toList();

        List<StudentDto> studentDtoList = studentEntityList.stream()
                .map(studentMapper::mapToDto).toList();

        log.info("ActionLog.filterForGraduate.end");

        return studentDtoList;
    }

    public void saveStudent(StudentSaveDto studentSaveDto) {

//        studentDto.stream()
//                .map(studentMapper::mapToDto)
//                .toList();

//        studentDto

        log.info("ActionLog.studentSaveDto.start");


        StudentEntity studentEntity=studentMapper.dtoToMap(studentSaveDto);

        studentRepository.save(studentEntity);

        log.info("ActionLog.studentSaveDto.end");

    }

    public void editGraduate(Long studentId){

        log.info("ActionLog.editGraduate.start {}", studentId);

        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        if(studentEntity.isPresent()){

            StudentEntity studentEntity1 = studentEntity.get();

            studentEntity1.setIsGraduate(!(studentEntity1.getIsGraduate()));

            studentRepository.save(studentEntity1);

        }

        log.info("ActionLog.editGraduate.end {}", studentId);


    }

    public void deleteStudent(Long customerId) {

        log.info("ActionLog.deleteStudent.start {}", customerId);

        studentRepository.deleteById(customerId);

        log.info("ActionLog.deleteStudent.start {}", customerId);

    }

    public void updateStudent(StudentDto studentDto, Long customerId) {


        log.info("ActionLog.updateStudent.start {}", customerId);


        Optional<StudentEntity> studentEntity =  studentRepository.findById(customerId);
//
        System.out.println(studentEntity.get());
        if(studentEntity.isPresent()) {
            StudentEntity studentEntity1 = studentEntity.get();

//            studentEntity1.setStudentid(studentDto.getStudentId());
            studentEntity1.setName(studentDto.getName());
            studentEntity1.setSurname(studentDto.getSurname());
            studentEntity1.setIsGraduate(studentDto.isGraduate());

            studentRepository.save(studentEntity1);

        }

        log.info("ActionLog.updateStudent.end {}", customerId);


    }

    public StudentEntity findByNameAndSurname(String name,String surname){

        return studentRepository.findByNameAndSurname(name,surname);

    }


}
