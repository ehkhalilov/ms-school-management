package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.repository.StudentRepository;
import com.example.schoolmanagement.dao.repository.TeacherRepository;
import com.example.schoolmanagement.exception.NotFoundException;
import com.example.schoolmanagement.maper.TeacherMapper;
import com.example.schoolmanagement.model.TeacherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.schoolmanagement.enums.Exceptions.TEACHER_NOT_FOUND;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final StudentRepository studentRepository;


    public void addTeacher(TeacherDto teacherDto) {
        var teacherEntity = teacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacherEntity);
    }

    public TeacherDto getTeacher(Long id) {
        var entity = teacherRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        TEACHER_NOT_FOUND.name(), String.format(TEACHER_NOT_FOUND.getMessage(), id)
                )
        );

        return teacherMapper.mapToDto(entity);
    }

    public void assigneeStudentToTeacher(Long teacherId, Long studentId) {
        var student = studentRepository.findById(studentId).orElseThrow();
        var teacher = teacherRepository.findById(teacherId).orElseThrow();
//        var list = teacher.getStudents();
//        list.add(student);
//        teacher.setStudents(list);
        student.getTeachers().add(teacher);
//        teacherRepository.save(teacher);
        studentRepository.save(student);
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void changeTeachers() {
//        TeacherEntity teacherEntity = TeacherEntity.builder()
//                .name("Murad")
//                .birthDate(LocalDate.now())
//                .surname("Veliyev")
//                .build();
        var teacher1 = teacherRepository.findById(1L).orElseThrow();
        teacher1.setName("Elnur");
//        teacherRepository.save(teacher1);
        var teacher2 = teacherRepository.findById(2L).orElseThrow();
        teacher2.setName("Vusal");
//        teacherRepository.save(teacher2);
    }
}
