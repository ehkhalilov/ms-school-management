    package com.example.schoolmanagement.dao.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import lombok.ToString;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @ToString
    @Table(name = "tasks")
    public class TaskEntity {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        @ManyToOne
        @JoinColumn(name = "student_id")
        private StudentEntity student;
    }
