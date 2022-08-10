package com.spring.backend.controller;
import com.spring.backend.controllers.CardController;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.CardDTO;
import com.spring.backend.entity.Card;
import com.spring.backend.entity.User;
import com.spring.backend.repository.CardRepository;
import com.spring.backend.service.CardService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CardControllerTest {

    @Autowired
    private CardRepository cardRepository;
    @MockBean
    private CardService cardService;
    @Autowired
    private CardController cardController;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserConverter userConverter;

    @Test
    public void getAllCards() {
        assertEquals(cardService.findAll().size(), cardController.getAllCards().size());
    }

    @Test
    public void getCardById() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Card card = new Card(1,"1234 3456 4567 7895", "2025-07-21","145","Patrick Smith", user);
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        when(cardService.findById(1)).thenReturn(cardDTO);
        assertEquals(cardDTO,cardController.getCardById(1));
        try {
            cardController.getCardById(1000);
        } catch (Exception e) {
            System.out.println("Card not found");
        }
    }

    @Test
    public void createCard() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        CardDTO newCard = new CardDTO();
        newCard.setCardNumber("1234 3456 4567 7895");
        newCard.setExpiryDate("2025-07-21");
        newCard.setCvv("145");
        newCard.setCardHolder("Patrick Smith");
        newCard.setUser(userConverter.userEntityToDto(user));
        CardDTO card = cardController.createCard(newCard);
        assertEquals("1234 3456 4567 7895", card.getCardNumber());
        assertEquals("2025-07-21", card.getExpiryDate());
        assertEquals("145", card.getCvv());
        assertEquals("Patrick Smith", card.getCardHolder());
    }

    @Test
    public void updateCard() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        CardDTO newCard = new CardDTO();
        newCard.setCardNumber("1234 3456 4567 7895");
        newCard.setExpiryDate("2025-07-21");
        newCard.setCvv("145");
        newCard.setCardHolder("Patrick Smith");
        newCard.setUser(userConverter.userEntityToDto(user));
        CardDTO card = cardController.createCard(newCard);
        CardDTO newCard1 = new CardDTO();
        newCard1.setCardNumber("1234 6666 7777 8888");
        newCard1.setExpiryDate("2030-12-26");
        newCard1.setCvv("145");
        newCard1.setCardHolder("Shivva");
        newCard1.setUser(userConverter.userEntityToDto(user));
        try {
            cardController.updateCard(1000, newCard);
            CardDTO cardDTO = cardController.updateCard(1, card);
            assertEquals("1234 3456 4567 7895", card.getCardNumber());
            assertEquals("2025-07-21", card.getExpiryDate());
            assertEquals("145", card.getCvv());
            assertEquals("Patrick Smith", card.getCardHolder());
        } catch (Exception e) {
            System.out.println("Card not found");
        }
    }
}
