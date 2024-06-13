package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.CardDto;
import com.example.schoolmanagement.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: nijataghayev
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @Operation(summary = "Get all cards", description = "Retrieve a list of all cards")
    @GetMapping
    public List<CardDto> getCards() {
        return cardService.getCards();
    }
}
