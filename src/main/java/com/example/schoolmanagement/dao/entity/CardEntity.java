package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Long cardNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
    @OneToOne(mappedBy = "card")
    private StudentEntity student;

}
