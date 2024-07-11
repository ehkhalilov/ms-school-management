package com.example.schoolmanagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exceptions {
    TEACHER_NOT_FOUND("ActionLog.getTeacher.error teacher with %d not found"),
    STUDENT_NOT_FOUND("ActionLog.getStudent.error student with %d not found");

    private final String message;

}
