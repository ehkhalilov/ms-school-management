package com.example.schoolmanagement.model.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskSetDto {
    private String title;
    private String description;
    private LocalDate dueDate;
}