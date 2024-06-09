package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TaskRepository;
import com.example.schoolmanagement.enums.Grade;
import com.example.schoolmanagement.maper.StudentMapper;
import com.example.schoolmanagement.model.StudentDto;
import com.example.schoolmanagement.model.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();

        return studentEntityList.stream()
                .map(studentMapper::mapToDto)
                .filter(student -> !student.getGraduated())
                .toList();
    }

    public StudentDto getStudent(Long studentId) {
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        return studentMapper.mapToDto(studentEntity);
    }

    public void saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        studentEntity.setGrade(Grade.scoreToGrade(studentDto.getScore()));
        studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(StudentDto studentDto, Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student_NOT_FOUND"));
        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setGraduated(studentDto.getGraduated());
        studentRepository.save(studentEntity);
    }

    public void assignTask(Long studentId, Long taskId){
        var studentEntity = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task isnt exist"));
        taskEntity.setStudent(studentEntity);
        studentEntity.getTasks().add(taskEntity);
        studentRepository.save(studentEntity);
    }

    public void deleteTaskFromStudent(Long studentId, Long taskId){
        var studentEntity = studentRepository.findById(studentId).orElseThrow();
        var taskEntity = taskRepository.findById(taskId).orElseThrow();
        var studentTasks = studentEntity.getTasks().stream().filter(task -> task.getId().equals(taskId)).collect(Collectors.toList());
        studentEntity.setTasks(studentTasks);
        taskEntity.setStudent(null);
        studentRepository.save(studentEntity);
        taskRepository.save(taskEntity);
    }
}
