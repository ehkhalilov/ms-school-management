package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.CardDto;
import com.example.schoolmanagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardDto> getAllCards(){
       return cardService.getAllCards();
    }
}
