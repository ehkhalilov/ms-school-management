package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.CardEntity;
import com.example.schoolmanagement.dao.repository.CardRepository;
import com.example.schoolmanagement.exceptions.NotFound;
import com.example.schoolmanagement.maper.CardMapper;
import com.example.schoolmanagement.model.CardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public List<CardDto> getCards() {
        log.info("ActionLog.getCards.start");
        List<CardEntity> cards = cardRepository.findAll();
        List<CardDto> cardDtoList = cards.stream().map(cardMapper::mapToDto).toList();
        log.info("ActionLog.getCards.end");

        return cardDtoList;
    }

    public CardDto getCardById(Long cardId) {
        log.info("ActionLog.getCardById.start card {}", cardId);

        CardEntity cardEntity = findCard(cardId);
        CardDto cardDto = cardMapper.mapToDto(cardEntity);

        log.info("ActionLog.getCardById.end card {}", cardId);
        return cardDto;
    }

    public void saveCard(CardDto cardDto){
        log.info("ActionLog.saveCard.start");

        CardEntity cardEntity = cardMapper.mapToEntity(cardDto);
        cardRepository.save(cardEntity);

        log.info("ActionLog.saveCard.end");
    }

    public void editCard(Long cardId,CardDto cardDto){
        log.info("ActionLog.editCard.start card {}", cardId);

        CardEntity cardEntity = findCard(cardId);

        if(cardDto.getCardNumber()!=null){
            cardEntity.setCardNumber(cardDto.getCardNumber());
        }
        if(cardDto.getExpireDate()!=null){
            cardEntity.setExpireDate(cardDto.getExpireDate());
        }

        cardRepository.save(cardEntity);
        log.info("ActionLog.editCard.end card {}", cardId);
    }

    public CardDto deleteCard(Long cardId){
        log.info("ActionLog.deleteCard.start card {}",cardId);

        CardEntity cardEntity = findCard(cardId);
        CardDto cardDto = cardMapper.mapToDto(cardEntity);
        cardRepository.deleteById(cardId);

        log.info("ActionLog.deleteCard.end card {}",cardId);
        return cardDto;
    }
    private CardEntity findCard(Long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).
                orElseThrow(() -> new NotFound("CARD_NOT_FOUND", "Error ActionLog.findCard cardId {" + cardId + "}"));
        return cardEntity;
    }
}
