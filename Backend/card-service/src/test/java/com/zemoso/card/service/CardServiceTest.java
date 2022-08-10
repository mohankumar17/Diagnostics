package com.zemoso.card.service;

import com.zemoso.card.dto.CardDTO;
import com.zemoso.card.entity.Card;
import com.zemoso.card.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CardServiceTest {

    @Autowired
    private CardService cardService;
    @MockBean
    private CardRepository cardRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void findAll() {
        Card card1 = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        Card card2 = new Card(2, "1234 5678 9101 1121", "25/25", "456", "Nathan", 2);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        when(cardRepository.findAll()).thenReturn(cards);
        assertEquals(cards.stream().map(card -> modelMapper.map(card, CardDTO.class)).collect(Collectors.toList()), cardService.findAll());
    }

    @Test
    void findCardById() {
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        when(cardRepository.findById(1)).thenReturn(Optional.of(card));
        cardService.findById(1000);
        assertEquals(modelMapper.map(card, CardDTO.class), cardService.findById(1));
    }

    @Test
    void saveCard() {
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        cardService.save(cardDTO);
        assertEquals("1234 1234 1234 1234", cardDTO.getCardNumber());
        assertEquals("12/34", cardDTO.getExpiryDate());
        assertEquals("123", cardDTO.getCvv());
        assertEquals("Viswa", cardDTO.getCardHolder());
    }

    @Test
    void updateCard(){
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        cardService.update(1000, cardDTO);
        when(cardRepository.findById(1)).thenReturn(Optional.of(card));
        Card updatedCard = cardService.update(1, cardDTO);
        assertEquals("1234 1234 1234 1234", updatedCard.getCardNumber());
        assertEquals("12/34", updatedCard.getExpiryDate());
        assertEquals("123", updatedCard.getCvv());
        assertEquals("Viswa", updatedCard.getCardHolder());
    }
}
