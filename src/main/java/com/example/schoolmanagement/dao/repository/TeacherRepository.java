package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: nijataghayev
 */
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
