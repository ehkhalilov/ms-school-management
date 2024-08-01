package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.UserEntity;
import com.example.schoolmanagement.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(UserDto userDto);
}
