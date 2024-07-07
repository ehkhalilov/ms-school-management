package com.example.schoolmanagement.service

import com.example.schoolmanagement.dao.entity.StudentEntity
import com.example.schoolmanagement.dao.repository.StudentRepository
import com.example.schoolmanagement.dao.repository.TeacherRepository
import com.example.schoolmanagement.maper.StudentMapper
import com.example.schoolmanagement.model.StudentDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class StudentServiceTest extends Specification {
    private StudentService studentService
    private StudentRepository studentRepository
    private TeacherRepository teacherRepository
    private StudentMapper studentMapper
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
//        random = EnhancedRandomBuilder.aNewEnhancedRandom()
        studentRepository=Mock()
        teacherRepository=Mock()
        studentMapper=Mock()
        studentService = new StudentService(studentRepository,teacherRepository,studentMapper)
    }

    def "GetStudent"() {
        given:
        def studentId=1
        def studentEntity = random.nextObject(StudentEntity)
        def studentDto = random.nextObject(StudentDto)
        when:
        def result = studentService.getStudent(studentId)
        then:
        1*studentService.findStudent(100) >> Optional.of(studentEntity)
        1*studentMapper.mapToDto(studentEntity) >> studentDto

        result==studentDto
    }

}
