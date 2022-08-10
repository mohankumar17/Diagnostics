package com.spring.backend.service;

import com.spring.backend.dto.CardDTO;
import com.spring.backend.entity.Card;
import com.spring.backend.entity.User;
import com.spring.backend.repository.CardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void saveCard(){
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Card newCard = new Card(2, "1234 1234 1234 1234","12/34", "123", "Viswa", user);
        CardDTO cardDTO = modelMapper.map(newCard, CardDTO.class);
        cardService.save(cardDTO);
    }

    @Test
    public void findAllCard(){
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Card newCard = new Card(2, "1234 1234 1234 1234","12/34", "123", "Viswa", user);
        List<Card>  cards = new ArrayList<>();
        cards.add(newCard);
        when(cardRepository.findAll()).thenReturn(cards);
        assertEquals(1, cardService.findAll().size());
    }

    @Test
    public void findCardById(){
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Card newCard = new Card(2, "1234 1234 1234 1234","12/34", "123", "Viswa", user);
        when(cardRepository.findById(2)).thenReturn(Optional.of(newCard));
        assertEquals("1234 1234 1234 1234",cardService.findById(2).getCardNumber());

    }

    @Test
    public void updateCard(){
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Card newCard = new Card(2, "1234 1234 1234 1234","12/34", "123", "Viswa", user);
        CardDTO cardDTO = modelMapper.map(newCard, CardDTO.class);
        Card card = cardService.update(1, cardDTO);

    }
}
