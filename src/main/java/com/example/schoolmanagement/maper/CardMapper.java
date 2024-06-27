package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.model.CardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto mapToDto(CardEntity cardEntity);
    CardEntity mapToEntity(CardDto cardDto);
}
