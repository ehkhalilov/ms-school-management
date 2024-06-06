package com.example.schoolmanagement.service;


import com.example.schoolmanagement.dao.repository.CardRepository;
import com.example.schoolmanagement.maper.CardMapper;
import com.example.schoolmanagement.model.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public List<CardDto> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::mapToDto).toList();
    }
}
