package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
//    @Modifying
//    @Query("update students s set s.name = ?1, s.surname= ?2, " +
//            "s.score= ?3, s.birthdate= ?4, s.course= ?5 where s.id = ?6")
//    void setStudentInfoById(String name, String surname, Double score,
//                            LocalDate birthdate, String course, Long userId);

}
