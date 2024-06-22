package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity mapToEntity(TaskDto taskDto);
    TaskDto mapToDto(TaskEntity taskEntity);

}
