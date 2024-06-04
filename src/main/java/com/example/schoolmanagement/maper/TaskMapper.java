package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    TaskEntity taskDtoToTaskEntity(TaskDto taskDto);
    TaskDto taskToTaskDto(TaskEntity taskEntity);

    TaskEntity mapToEntity(TaskDto taskDto);
    void dtoToTaskEntity(@MappingTarget TaskEntity taskEntity, TaskDto taskDto);

}
