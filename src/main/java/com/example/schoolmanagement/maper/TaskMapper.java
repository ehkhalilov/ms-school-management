package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    public abstract List<TaskDto> mapToDtoList(List<TaskEntity> taskEntity);
    public abstract TaskDto mapToDto(TaskEntity taskEntity);
    public abstract TaskEntity mapToEntity(TaskDto taskDto);
}
