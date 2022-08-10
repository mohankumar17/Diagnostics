package com.zemoso.card.service;

import com.zemoso.card.dto.CardDTO;
import com.zemoso.card.entity.Card;

import java.util.List;

public interface CardService {

    public List<CardDTO> findAll();

    public CardDTO findById(int theId);

    public void save(CardDTO theCard);

    public Card update(int theId, CardDTO theCard);
}
