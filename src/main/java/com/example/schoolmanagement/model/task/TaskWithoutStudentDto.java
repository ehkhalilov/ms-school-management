package com.example.schoolmanagement.model.task;

import com.example.schoolmanagement.model.student.StudentDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskWithoutStudentDto {
    private String id;
    private String title;
    private String description;

}