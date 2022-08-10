package com.zemoso.card.controller;

import com.zemoso.card.dto.CardDTO;
import com.zemoso.card.entity.Card;
import com.zemoso.card.service.CardService;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class CardControllerTest {

    @Autowired
    private CardController cardController;
    @MockBean
    private CardService cardService;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void getAllCards(){
        Card card1 = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        Card card2 = new Card(2, "1234 5678 9101 1121", "25/25", "456", "Nathan", 2);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        when(cardService.findAll()).thenReturn(cards.stream().map(card -> modelMapper.map(card, CardDTO.class)).collect(Collectors.toList()));
        assertEquals(cards.stream().map(card -> modelMapper.map(card, CardDTO.class)).collect(Collectors.toList()), cardController.getAllCards());
    }

    @Test
    void getCardById(){
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        when(cardService.findById(1)).thenReturn(modelMapper.map(card, CardDTO.class));
        assertEquals(modelMapper.map(card, CardDTO.class), cardController.getCardById(1));
        try{
            cardController.getCardById(1000);
        }catch (Exception e){
            System.out.println("Card not found");
        }
    }

    @Test
    void createCard(){
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        cardController.createCard(cardDTO);
        assertEquals("1234 1234 1234 1234", cardDTO.getCardNumber());
        assertEquals("12/34", cardDTO.getExpiryDate());
        assertEquals("123", cardDTO.getCvv());
        assertEquals("Viswa", cardDTO.getCardHolder());
    }

    @Test
    void updateCard(){
        Card card = new Card(1, "1234 1234 1234 1234", "12/34", "123", "Viswa", 1);
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        when(cardService.update(1,cardDTO)).thenReturn(card);
        CardDTO updatedCard =  cardController.updateCard(1, cardDTO);
        assertEquals("1234 1234 1234 1234", updatedCard.getCardNumber());
        assertEquals("12/34", updatedCard.getExpiryDate());
        assertEquals("123", updatedCard.getCvv());
        assertEquals("Viswa", updatedCard.getCardHolder());
        try{
            cardController.updateCard(1000, cardDTO);
        }catch (Exception e){
            System.out.println("Card not found");
        }
    }
}
