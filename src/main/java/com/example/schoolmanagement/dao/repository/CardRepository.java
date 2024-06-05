package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: nijataghayev
 */
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
