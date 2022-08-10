package com.zemoso.card.service;


import com.zemoso.card.dto.CardDTO;
import com.zemoso.card.entity.Card;
import com.zemoso.card.repository.CardRepository;
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
            card.setUserId(theCard.getUserId());
            cardRepository.save(card);
        }
        return card;
    }
}
