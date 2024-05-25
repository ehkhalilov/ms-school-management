package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

//    @Modifying
//    @Query(value = "update students s set name = :name where id = :id", nativeQuery = true)
//    int updateNameById(String name, Long id);
//
//    @Query(value = "select s from StudentEntity s where s.id = :id")
//    Optional<StudentEntity> findById(Integer id);
}
