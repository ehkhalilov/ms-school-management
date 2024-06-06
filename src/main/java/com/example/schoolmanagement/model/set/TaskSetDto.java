package com.example.schoolmanagement.model.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TaskSetDto {
    private String title;
    private String description;
    private LocalDate dueDate;
}
