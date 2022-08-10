package com.spring.backend.service;

import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.CardDTO;
import com.spring.backend.entity.Card;
import com.spring.backend.entity.User;
import com.spring.backend.repository.CardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardImpl implements CardService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserConverter userConverter;

    private CardRepository cardRepository;

    @Autowired
    public CardImpl(CardRepository theCardRepository) {
        cardRepository = theCardRepository;
    }

    @Override
    public List<CardDTO> findAll() {
        return cardRepository.findAll().stream().map(card -> modelMapper.map(card, CardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CardDTO findById(int theId) {
        Optional<Card> result = cardRepository.findById(theId);
        CardDTO theCard = null;
        if (result.isPresent()) {
            theCard = modelMapper.map(result.get(), CardDTO.class);
        }
        return theCard;
    }

    @Override
    public void save(CardDTO theCard) {
        Card card = modelMapper.map(theCard, Card.class);
        User user = userConverter.userDtoToEntity(theCard.getUser());
        user.add(card);
        cardRepository.save(card);
    }

    @Override
    public Card update(int theId, CardDTO theCard) {
        Optional<Card> result = cardRepository.findById(theId);
        Card card = null;
        if (result.isPresent()) {
            card = result.get();
            card.setCardNumber(theCard.getCardNumber());
            card.setExpiryDate(theCard.getExpiryDate());
            card.setCvv(theCard.getCvv());
            card.setCardHolder(theCard.getCardHolder());
            User user = userConverter.userDtoToEntity(theCard.getUser());
            card.setUser(user);
            cardRepository.save(card);
        }
        return card;
    }
}
