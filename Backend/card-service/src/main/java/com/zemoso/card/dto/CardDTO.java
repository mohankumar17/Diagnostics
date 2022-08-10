package com.zemoso.card.dto;

import lombok.Data;

@Data
public class CardDTO {
    private int id;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolder;
    private int userId;
}
