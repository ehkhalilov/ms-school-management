package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.CardDto;
import com.example.schoolmanagement.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @Operation(description = "It's for getting all cards")
    @GetMapping
    public List<CardDto> getCards() {
        return cardService.getCards();
    }

    @Operation(description = "It's for getting card by id")
    @GetMapping("/{cardId}")
    public CardDto getCardById(@PathVariable Long cardId){
        return cardService.getCardById(cardId);
    }

    @Operation(description = "It's for saving new card")
    @PostMapping
    public void saveCard(@RequestBody CardDto cardDto){
        cardService.saveCard(cardDto);
    }

    @Operation(description = "It's for editing card by id")
    @PutMapping("/{cardId}")
    public void editCard(@PathVariable Long cardId,@RequestBody CardDto cardDto){
        cardService.editCard(cardId,cardDto);
    }

    @DeleteMapping("/{cardId}")
    public CardDto deleteCard(@PathVariable Long cardId){
        return cardService.deleteCard(cardId);
    }
}
