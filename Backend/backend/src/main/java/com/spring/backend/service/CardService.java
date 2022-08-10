package com.spring.backend.service;

import com.spring.backend.dto.CardDTO;
import com.spring.backend.entity.Card;

import java.util.List;

public interface CardService {

    public List<CardDTO> findAll();

    public CardDTO findById(int theId);

    public void save(CardDTO theCard);

    public Card update(int theId, CardDTO theCard);
}
