package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
