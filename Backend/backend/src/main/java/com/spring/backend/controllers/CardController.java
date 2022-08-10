package com.spring.backend.controllers;

import com.spring.backend.dto.CardDTO;
import com.spring.backend.entity.Card;
import com.spring.backend.exceptions.CardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.backend.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private CardService CardService;

    @Autowired
    public CardController(CardService theCardService) {
        this.CardService = theCardService;
    }

    @GetMapping("/")
    public List<CardDTO> getAllCards() {
        return CardService.findAll();
    }

    @GetMapping("/{id}")
    public CardDTO getCardById(@PathVariable(name = "id") int id) {
        CardDTO card = CardService.findById(id);
        if (card == null) {
            throw new CardNotFoundException("Card not found!!");
        }
        return card;
    }

    @PostMapping("/")
    public CardDTO createCard(@RequestBody CardDTO theCard) {
        CardService.save(theCard);
        return theCard;
    }

    @PutMapping("/{id}")
    public CardDTO updateCard(@PathVariable int id, @RequestBody CardDTO theCard) {
        Card card = CardService.update(id, theCard);
        if (card == null) {
            throw new CardNotFoundException("Card not found!!");
        }
        return theCard;
    }
}
