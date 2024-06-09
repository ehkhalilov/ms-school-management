package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.card.CardDto;
import com.example.schoolmanagement.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardDto> getAllCards(){
        log.info("Action.getAllCards.start");
        List<CardDto> list = cardService.getAllCards();
        log.info("Action.getAllCards.end");
        return list;
    }
}
