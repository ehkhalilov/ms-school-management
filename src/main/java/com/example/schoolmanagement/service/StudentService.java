package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.entity.TeacherEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentFullInfoDto;
import com.example.schoolmanagement.model.enums.Grade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final TaskRepository taskRepository;
    private final TeacherRepository teacherRepository;

    private StudentEntity getStudentByID(Long studentId) {
        return studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                            "STUDENT_NOT_FOUND",
                            String.format("ActionLog.getStudentByID studentId=%d",
                                    studentId))
                );

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

    public StudentDto getStudent(Long studentId) {
        log.info("ActionLog.getStudent.start studentId={}", studentId);
        var studentDto = studentMapper.mapToDto(getStudentByID(studentId));
        log.info("ActionLog.getStudent.end studentId={}", studentId);

        return studentDto;
    }

    public void saveStudent(StudentDto studentDto) {
        log.info("ActionLog.saveStudent.start studentDto={}", studentDto);
        studentRepository.save(studentMapper.mapToEntity(studentDto));
        log.info("ActionLog.saveStudent.end studentDto={}", studentDto);
    }

    public void deleteStudent(Long studentId) {
        log.info("ActionLog.deleteStudent.start studentId={}", studentId);
        studentRepository.deleteById(studentId);
        log.info("ActionLog.deleteStudent.end studentId={}", studentId);
    }

    public void updateStudent(StudentFullInfoDto studentFullInfoDto, Long studentId) {
        log.info("ActionLog.updateStudent.start studentFullInfoDto={}, studentId={}",
                studentFullInfoDto, studentId);

        studentFullInfoDto.setId(studentId);
        studentRepository.save(studentMapper.mapToEntity(studentFullInfoDto));

        log.info("ActionLog.updateStudent.end studentFullInfoDto={}, studentId={}",
                studentFullInfoDto, studentId);
    }
    public String isStudentGraduated(Long studentId) {
        log.info("ActionLog.getGraduated.start studentId={}", studentId);

        var studentEntity = getStudentByID(studentId);
        String str = studentEntity.getName() + " "
                + studentEntity.getSurname() + " is"
                + (studentEntity.getGraduated()? "" : " not")
                + " graduated.";

        log.info("ActionLog.getGraduated.end studentId={}", studentId);

        return str;
    }

    public String getStudentGrade(Long studentId) {
        log.info("ActionLog.getStudentGrade.start studentId={}", studentId);

        var studentEntity = getStudentByID(studentId);
        String str = studentEntity.getName() + " "
                + studentEntity.getSurname() + " : "
                + Grade.convertToGrade(studentEntity.getScore()).toString()
                + " in " + studentEntity.getSubject() + " course";

        log.info("ActionLog.getStudentGrade.end studentId={}", studentId);

        return str;
    }

    public void updateStudentIsGraduated(Long studentId, Boolean isGraduated) {
        log.info("ActionLog.updateStudentIsGraduated.start studentId={}", studentId);

        var studentEntity = getStudentByID(studentId);
        studentEntity.setGraduated(isGraduated);

        studentRepository.save(studentEntity);

        log.info("ActionLog.updateStudentIsGraduated.end studentId={}", studentId);
    }

    public List<StudentDto> getGraduatedStudents() {
        log.info("ActionLog.getGraduatedStudents.start");

        List<StudentEntity> studentEntityList = studentRepository.findAll();

        List<StudentDto> graduatedStudentsList = studentEntityList.
                        stream().
                        filter(StudentEntity::getGraduated).
                        map(studentMapper::mapToDto).
                        toList();

        log.info("ActionLog.getGraduatedStudents.end");

        return graduatedStudentsList;
    }
    public void deleteTask(Long studentId, Long taskId) {
        log.info("ActionLog.deleteTask.start studentId={}, taskId={}",
                studentId, taskId);

        StudentEntity studentEntity = getStudentByID(studentId);

        var tasksIdList =
                studentEntity.
                getTasks().
                stream().
                map(TaskEntity::getId).toList();

        if(!tasksIdList.contains(taskId)) {
            log.error("ActionLog.deleteTask.taskId={}", taskId);
            throw new RuntimeException(
                    "Not allowed to remove another student's task");
        }

        taskRepository.deleteById(taskId);

        log.info("ActionLog.deleteTask.end studentId={}, taskId={}",
                studentId, taskId);
    }
    public void assignStudentToTeacher(Long studentId, Long teacherId) {
        log.info("ActionLog.assignStudentToTeacher.start teacherId={} studentId={}",
                teacherId, studentId);

        StudentEntity studentEntity = getStudentByID(studentId);
        TeacherEntity teacherEntity =
                        teacherRepository.
                        findById(teacherId).
                        orElseThrow(() -> {
                            log.error("ActionLog.assignStudentToTeacher teacherId={}", teacherId);
                            return new RuntimeException("STUDENT_NOT_FOUND");}
                        );

        var teachersList = studentEntity.getTeachers();
        teachersList.add(teacherEntity);
        studentEntity.setTeachers(teachersList);
        studentRepository.save(studentEntity);

        log.info("ActionLog.assignStudentToTeacher.end teacherEntity={} studentId={}",
                teacherId, studentId);
    }
}
