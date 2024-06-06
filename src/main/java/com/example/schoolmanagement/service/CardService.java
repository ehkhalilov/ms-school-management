package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.dao.repository.CardRepository;
import com.example.schoolmanagement.maper.CardMapper;
import com.example.schoolmanagement.model.CardDto;
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

    public List<CardDto> getCards() {
        log.info("ActionLog.getCards.start");
        List<CardEntity> cards = cardRepository.findAll();
        List<CardDto> cardDtoList = cardMapper.mapToDto(cards);
        log.info("ActionLog.getCards.end");

        return cardDtoList;
    }
}
