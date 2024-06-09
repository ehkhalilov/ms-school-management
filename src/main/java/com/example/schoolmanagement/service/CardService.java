package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.repository.CardRepository;
import com.example.schoolmanagement.maper.CardMapper;
import com.example.schoolmanagement.model.card.CardDto;
import com.example.schoolmanagement.model.card.CardWithoutStudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;


    public List<CardDto> getAllCards(){
        List<CardDto> cardDtos = cardRepository.findAll().stream().map(cardMapper::mapToDto).toList();
        return cardDtos;
    }
}
