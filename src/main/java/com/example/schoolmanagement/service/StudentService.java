package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.maper.TaskMapper;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.StudentWithMarkDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final TaskRepository taskRepository;
    private final StudentMapper studentMapper;
    private final TaskMapper taskMapper;

    public List<StudentWithMarkDto> getAllStudents() {
        log.info("ActionLog.getAllStudent.start");
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentWithMarkDto> studentWithMarkDtos = studentEntityList.stream()
                .map(studentMapper::toDto)
                .toList();
        log.info("ActionLog.getAllStudent.end");

        return studentWithMarkDtos;
    }

    public StudentWithMarkDto getStudent(Long customerId) {
        log.info("ActionLog.getStudent.start customerId {}", customerId);
        var studentEntity = studentRepository
                .findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.getStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
        var studentWithMarkDto = studentMapper.toDto(studentEntity);
        log.info("ActionLog.getStudent.end customerId {}", customerId);

        return studentWithMarkDto;
    }

    public void saveStudent(StudentDto studentDto) {
        log.debug("ActionLog.saveStudent.start student {}", studentDto);
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        studentEntity.setGraduated(false);
        studentRepository.save(studentEntity);
        log.debug("ActionLog.saveStudent.end student {}", studentDto);
    }

    public void deleteStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });
        studentRepository.delete(studentEntity);
    }

    public void deleteTask(Long studentId, Long taskId) {
        log.info("ActionLog.deleteTask.start studentId {}, taskId {}", studentId, taskId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteTask.studentId {} not found", studentId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteTask.taskId {} not found", taskId);
                    return new RuntimeException("TASK_NOT_FOUND");
                });

        if (!taskEntity.getStudent().getId().equals(studentId)) {
            log.error("ActionLog.deleteTask.taskId {} does not belong to studentId {}", taskId, studentId);
            throw new RuntimeException("TASK_DOES_NOT_BELONG_TO_STUDENT");
        }

        studentEntity.getTasks().remove(taskEntity);
        taskEntity.setStudent(null);

        studentRepository.save(studentEntity);
        taskRepository.save(taskEntity);

        log.info("ActionLog.deleteTask.end studentId {}, taskId {}", studentId, taskId);
    }

    public void deleteAllTasks(Long studentId) {
        log.info("ActionLog.deleteAllTasks.start studentId {}", studentId);

        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("ActionLog.deleteAllTasks.studentId {} not found", studentId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        List<TaskEntity> tasks = studentEntity.getTasks();

        for (TaskEntity task : tasks) {
            taskRepository.delete(task);
        }

        studentEntity.getTasks().clear();
        studentRepository.save(studentEntity);

        log.info("ActionLog.deleteAllTasks.end studentId {}", studentId);
    }

    public void updateStudent(StudentDto studentDto, Long customerId) {
        StudentEntity existingStudent = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.updateStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        StudentEntity updatedStudent = studentMapper.mapToEntity(studentDto);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setScore(updatedStudent.getScore());
        existingStudent.setBirthDate(updatedStudent.getBirthDate());
        existingStudent.setCourse(updatedStudent.getCourse());

        studentRepository.save(existingStudent);
    }

    public void graduatedStudent(Long customerId) {
        StudentEntity studentEntity = studentRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("ActionLog.graduatedStudent.id {} not found", customerId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        studentEntity.setGraduated(true);
        studentRepository.save(studentEntity);
    }

    public StudentDto assignTask(Long studentId, Long taskId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("ActionLog.graduatedStudent.id {} not found", studentId);
                    return new RuntimeException("STUDENT_NOT_FOUND");
                });

        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> {
                    log.error("ActionLog.assingTask.id {} not found", taskId);
                    return new RuntimeException("TASK_NOT_FOUND");
                });

        taskEntity.setStudent(studentEntity);
        studentEntity.getTasks().add(taskEntity);

        studentRepository.save(studentEntity);

        return studentMapper.mapToDto(studentEntity);
    }
}
