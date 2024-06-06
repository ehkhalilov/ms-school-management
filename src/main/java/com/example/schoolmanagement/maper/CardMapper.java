package com.example.schoolmanagement.maper;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.model.CardDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
@Mapper(componentModel = "spring")
public abstract class CardMapper {

    public abstract CardDto mapToDto(CardEntity card);
    public abstract CardEntity mapToEntity(CardDto card);
}
