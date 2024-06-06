package com.example.schoolmanagement.mapper;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.model.get.CardGetDto;
import com.example.schoolmanagement.model.set.CardSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {StudentMapper.class})
public abstract class CardMapper {
    @Mapping(target = "student", source = "studentEntity")
    public abstract CardGetDto mapToDto(CardEntity cardEntity);

    public abstract CardEntity mapToEntity(CardSetDto cardSetDto);
}
