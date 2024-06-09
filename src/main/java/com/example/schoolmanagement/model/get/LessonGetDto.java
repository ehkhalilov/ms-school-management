package com.example.schoolmanagement.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonGetDto {
    private Long id;
    private String name;
    private Long akts;
    private List<TeacherGetDto> teacherGetDtos;
}
