package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.get.TaskGetDto;
import com.example.schoolmanagement.model.set.TaskSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public abstract class TaskMapper {
    @Mapping(target = "studentGetDto", source = "studentEntity")
    public abstract TaskGetDto mapToDto(TaskEntity taskEntity);

    public abstract TaskEntity mapToEntity(TaskSetDto taskSetDto);

    public abstract List<TaskGetDto> mapToDtos(List<TaskEntity> taskEntities);
}
