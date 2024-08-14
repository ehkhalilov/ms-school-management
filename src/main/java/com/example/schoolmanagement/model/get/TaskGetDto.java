package com.example.schoolmanagement.model.get;

import com.example.schoolmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TaskGetDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate createDate;
    private LocalDate assignedDate;
    private LocalDate dueDate;
    private StudentGetDto studentGetDto;
}
