package com.example.schoolmanagement.service

import com.example.schoolmanagement.dao.entity.StudentEntity
import com.example.schoolmanagement.dao.repository.StudentRepository
import com.example.schoolmanagement.exception.NotFoundException
import com.example.schoolmanagement.maper.StudentMapper
import com.example.schoolmanagement.model.StudentDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification
import spock.lang.Unroll

import static com.example.schoolmanagement.enums.Exceptions.STUDENT_NOT_FOUND

class StudentServiceTest extends Specification {
    private EnhancedRandom random
    private StudentService studentService
    private StudentMapper studentMapper
    private StudentRepository studentRepository

    void setup() {
        random = EnhancedRandomBuilder.aNewEnhancedRandom()
        studentMapper = Mock()
        studentRepository = Mock()
        studentService = new StudentService(studentRepository, studentMapper)
    }

    @Unroll
    def "GetStudent success"() {
        given:
        def studentEntity = random.nextObject(StudentEntity)
        def studentDto = random.nextObject(StudentDto)

        when:
        def result = studentService.getStudent(studentId)

        then:
        1 * studentRepository.findById(studentId) >> Optional.of(studentEntity)
        1 * studentMapper.mapToDto(studentEntity) >> studentDto

        result == studentDto

        where:
        studentId << [1, 2, 5]
    }

    def "GetStudent StudentNotFound"() {
        given:
        def studentId = random.nextInt()

        when:
        def result = studentService.getStudent(studentId)

        then:
        1 * studentRepository.findById(studentId) >> Optional.empty()
        0 * studentMapper.mapToDto(_)

        def ex = thrown(NotFoundException)
        ex.code == STUDENT_NOT_FOUND.name()
        ex.message == String.format(STUDENT_NOT_FOUND.getMessage(), studentId)

        result == null
    }
}
