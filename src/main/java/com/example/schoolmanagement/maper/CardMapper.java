package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.model.CardDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface CardMapper {

    List<CardDto> mapToDto(List<CardEntity> cardEntity);
}
