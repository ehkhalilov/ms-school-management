package com.example.schoolmanagement.dao.repository;

import com.example.schoolmanagement.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity , String> {
}
