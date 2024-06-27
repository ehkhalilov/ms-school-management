package com.example.schoolmanagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exceptions {
    STUDENT_NOT_FOUND("ActionLog.findById.error student %d not found"),
    TEACHER_NOT_FOUND("ActionLog.findById.error teacher %d not found"),
    LESSON_NOT_FOUND("ActionLog.findById.error lesson %d not found"),
    TASK_NOT_FOUND("ActionLog.findById.error task %d not found");

    private final String log;
}
