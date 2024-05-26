package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
