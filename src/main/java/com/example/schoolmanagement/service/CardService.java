package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.dao.repository.CardRepository;
import com.example.schoolmanagement.mapper.CardMapper;
import com.example.schoolmanagement.model.get.CardGetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public List<CardGetDto> getAllCards(){
        log.info("ActionLog.getAllCards.start");
        List<CardEntity> cardEntities = cardRepository.findAll();
        List<CardGetDto> cardGetDtos = cardEntities.stream().map(cardMapper::mapToDto).toList();
        log.info("ActionLog.getAllCards.end");
        return cardGetDtos;
    }



}
