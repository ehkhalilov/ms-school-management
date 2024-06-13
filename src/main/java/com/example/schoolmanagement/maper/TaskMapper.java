package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.task.TaskDto;
import com.example.schoolmanagement.model.task.TaskWithoutStudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity mapToEntity(TaskDto taskDto);
    TaskDto mapToDto(TaskEntity taskEntity);

    TaskWithoutStudentDto mapToTaskWithoutStudentDto (TaskEntity taskEntity);

}
