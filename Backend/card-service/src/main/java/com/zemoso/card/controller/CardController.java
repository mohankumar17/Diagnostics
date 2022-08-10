package com.zemoso.card.controller;

import com.zemoso.card.dto.CardDTO;
import com.zemoso.card.entity.Card;
import com.zemoso.card.exception.CardNotFoundException;
import com.zemoso.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService theCardService) {
        this.cardService = theCardService;
    }

    @GetMapping("/")
    public List<CardDTO> getAllCards() {
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public CardDTO getCardById(@PathVariable(name = "id") int id) {
        CardDTO card = cardService.findById(id);
        if (card == null) {
            throw new CardNotFoundException("Card not found!!");
        }
        return card;
    }

    @PostMapping("/")
    public CardDTO createCard(@RequestBody CardDTO theCard) {
        cardService.save(theCard);
        return theCard;
    }

    @PutMapping("/{id}")
    public CardDTO updateCard(@PathVariable int id, @RequestBody CardDTO theCard) {
        Card card = cardService.update(id, theCard);
        if (card == null) {
            throw new CardNotFoundException("Card not found!!");
        }
        return theCard;
    }
}
