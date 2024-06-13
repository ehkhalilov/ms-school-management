package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.exception.ValidationException;
import com.example.schoolmanagement.maper.StudentMapper;
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

    public List<StudentWithMarkDto> getAllStudents() {
        log.info("ActionLog.getAllStudent.start");
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentWithMarkDto> studentWithMarkDtos = studentEntityList.stream()
                .map(studentMapper::toDto)
                .toList();
        log.info("ActionLog.getAllStudent.end");

        return studentWithMarkDtos;
    }

    public StudentWithMarkDto getStudent(Long studentId) {
        log.info("ActionLog.getStudent.start studentId {}", studentId);
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.getStudent.id %d not found", studentId)));
        var studentWithMarkDto = studentMapper.toDto(studentEntity);
        log.info("ActionLog.getStudent.end studentId {}", studentId);

        return studentWithMarkDto;
    }

    public void saveStudent(StudentDto studentDto) {
        log.debug("ActionLog.saveStudent.start student {}", studentDto);
        if(studentDto.getScore() < 50){
            throw new ValidationException("AGE_MUST_BE_MORE_THAN_50",
                    String.format("ActionLog.saveStudent.error student age must be more than 50, this now is %s" + studentDto.getScore()));
        }
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        studentEntity.setGraduated(false);
        studentRepository.save(studentEntity);
        log.debug("ActionLog.saveStudent.end student {}", studentDto);
    }

    public void deleteStudent(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.deleteStudent.id %d not found", studentId)));
        studentRepository.delete(studentEntity);
    }

    public void deleteTask(Long studentId, Long taskId) {
        log.info("ActionLog.deleteTask.start studentId {}, taskId {}", studentId, taskId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.deleteTask.id %d not found", studentId)));

        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException(
                        "TASK_NOT_FOUND",
                        String.format("ActionLog.deleteTask.id %d not found", taskId)));

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
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.deleteAllTasks.id %d not found", studentId)));

        List<TaskEntity> tasks = studentEntity.getTasks();

        for (TaskEntity task : tasks) {
            taskRepository.delete(task);
        }

        studentEntity.getTasks().clear();
        studentRepository.save(studentEntity);

        log.info("ActionLog.deleteAllTasks.end studentId {}", studentId);
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        StudentEntity existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.updateStudent.id %d not found", studentId)));

        StudentEntity updatedStudent = studentMapper.mapToEntity(studentDto);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setScore(updatedStudent.getScore());
        existingStudent.setBirthDate(updatedStudent.getBirthDate());
        existingStudent.setCourse(updatedStudent.getCourse());

        studentRepository.save(existingStudent);
    }

    public void graduatedStudent(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.graduatedStudent.id %d not found", studentId)));

        studentEntity.setGraduated(true);
        studentRepository.save(studentEntity);
    }

    public StudentDto assignTask(Long studentId, Long taskId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(
                        "STUDENT_NOT_FOUND",
                        String.format("ActionLog.assignTask.id %d not found", studentId)));

        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException(
                        "TASK_NOT_FOUND",
                        String.format("ActionLog.assignTask.id %d not found", taskId)));

        taskEntity.setStudent(studentEntity);
        studentEntity.getTasks().add(taskEntity);

        studentRepository.save(studentEntity);

        return studentMapper.mapToDto(studentEntity);
    }
}
