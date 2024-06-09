package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.model.card.CardDto;
import com.example.schoolmanagement.model.enums.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , imports = Mark.class)
public interface CardMapper {

    CardEntity mapToEntity(CardDto cardDto);
    CardDto mapToDto(CardEntity cardEntity);
}
