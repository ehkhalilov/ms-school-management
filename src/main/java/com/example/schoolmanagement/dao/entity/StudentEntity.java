package com.example.schoolmanagement.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Double score;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Integer course;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "card_id")
    private CardEntity card;
    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaskEntity> tasks;

    public StudentEntity(String name, String surname, LocalDate birthDate, Double score, Integer course) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getScore(), that.getScore()) && Objects.equals(getBirthDate(), that.getBirthDate()) && Objects.equals(getCourse(), that.getCourse()) && Objects.equals(getCard(), that.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getScore(), getBirthDate(), getCourse(), getCard());
    }
}
