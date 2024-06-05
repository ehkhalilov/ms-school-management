package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.TaskEntity;
import com.example.schoolmanagement.model.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto mapToDto(TaskEntity taskEntitiy);

    TaskEntity mapToEntity(TaskDto taskDto);

    void toEntity(@MappingTarget TaskEntity taskEntity, TaskDto taskDto);
}
