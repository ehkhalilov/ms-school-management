package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.TaskDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    public abstract TaskDto mapToDto(TaskEntity task);
    public abstract TaskEntity mapToEntity(TaskDto task);
}
