package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.Grade;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithGradeDto;
import com.example.schoolmanagement.model.TaskDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final TaskRepository taskRepository;
    private final StudentMapper studentMapper;
    private final TaskMapper taskMapper;

    public List<StudentDto> getAllStudents() {
        log.info("ActionLog.getAllStudents.starts");
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        var studentDtos = studentEntityList.stream()
                .map(studentMapper::studentToStudentDto)
                .toList();
        log.info("ActionLog.getAllStudents.ends");

        return studentDtos;
    }

    public StudentDto getStudent(Long studentId) {
        log.info("ActionLog.getStudent.starts studentId {}", studentId);
        var studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getStudent.studentNotFound {}", studentId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
        var studentDto = studentMapper.studentToStudentDto(studentEntity);
        log.info("ActionLog.getStudent.ends studentId {}", studentId);
        return studentDto;
    }


    public void saveStudent(StudentDto studentDto) {
        log.info("ActionLog.saveStudent.starts student {}", studentDto);
        try {
            var studentEntity = studentMapper.mapToEntity(studentDto);
            studentRepository.save(studentEntity);
        } catch (Exception e) {
            logger.error("Error saving student: ", e);
            throw new RuntimeException("Error saving student", e);
        }
        log.info("ActionLog.saveStudent.ends student {}", studentDto);
    }

    public void deleteStudent(Long studentId) {
        log.info("ActionLog.deleteStudent.starts studentId {}", studentId);
        logger.info("Deleting student with ID: {}", studentId);
        studentRepository.deleteById(studentId);
        log.info("ActionLog.deleteStudent.ends studentId {}", studentId);
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        log.info("ActionLog.updateStudent.starts studentId {}", studentId);
        logger.info("Updating student with ID: {}", studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        studentMapper.dtoToEntity(studentEntity, studentDto);
        studentRepository.save(studentEntity);
        log.info("ActionLog.updateStudent.ends studentId {}", studentId);
    }

    public Grade getStudentGrade(Long studentId) {
        log.info("ActionLog.getStudentGrade.starts studentId {}", studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        var grade = Grade.fromScore(studentEntity.getScore());
        log.info("ActionLog.getStudentGrade.ends studentId {}", studentId);
        return grade;
    }

    public StudentWithGradeDto getStudentWithGrade(Long studentId) {
        log.info("ActionLog.getStudentWithGrade.starts studentId {}", studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        //        Grade grade = Grade.fromScore(studentEntity.getScore());
        //        return new StudentWithGradeDto(
        //                studentEntity.getId(),
        //                studentEntity.getName(),
        //                studentEntity.getSurname(),
        //                studentEntity.getBirthDate(),
        //                studentEntity.getScore(),
        //                studentEntity.getCourse(),
        //                grade
        //        );
        var studentDto = studentMapper.toDto(studentEntity);
        log.info("ActionLog.getStudentWithGrade.ends studentId {}", studentId);
        return studentDto;
    }

    public StudentDto addTask(Long studentId, TaskDto taskDto) {
        log.info("ActionLog.addTask.starts studentId {}", studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        TaskEntity taskEntity = taskMapper.taskDtoToTaskEntity(taskDto);
        taskEntity.setStudent(studentEntity);

        studentEntity.getTasks().add(taskEntity);

        taskRepository.save(taskEntity);
        studentRepository.save(studentEntity);

        log.info("ActionLog.addTask.ends studentId {}", studentId);

        return studentMapper.studentToStudentDto(studentEntity);
    }

    public StudentDto assignTask(Long studentId, Long taskId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("TASK_NOT_FOUND"));

        taskEntity.setStudent(studentEntity);
        studentEntity.getTasks().add(taskEntity);

        studentRepository.save(studentEntity);

        return studentMapper.studentToStudentDto(studentEntity);

    }

    public void deleteTaskV1(Long studentId, Long taskId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        if (student.getTasks() == null || student.getTasks().isEmpty()) {
            throw new RuntimeException("Student with ID " + studentId + " has no tasks assigned.");
        }

        TaskEntity taskToRemove = null;
        for (TaskEntity task : student.getTasks()) {
            if (Objects.equals(task.getId(), taskId)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove == null) {
            throw new RuntimeException("Task with ID " + taskId + " not found for student with ID " + studentId);
        }

        student.getTasks().remove(taskToRemove);
        taskToRemove.setStudent(null);
        studentRepository.save(student);
    }

    public void deleteTaskV2(Long studentId, Long taskId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        if (student.getTasks() == null || student.getTasks().isEmpty()) {
            throw new RuntimeException("Student with ID " + studentId + " has no tasks assigned.");
        }

        TaskEntity taskToRemove = null;
        for (TaskEntity task : student.getTasks()) {
            if (Objects.equals(task.getId(), taskId)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove == null) {
            throw new RuntimeException("Task with ID " + taskId + " not found for student with ID " + studentId);
        }

        student.getTasks().remove(taskToRemove);
        taskToRemove.setStudent(null);

        taskRepository.delete(taskToRemove);

        studentRepository.save(student);
    }



}
