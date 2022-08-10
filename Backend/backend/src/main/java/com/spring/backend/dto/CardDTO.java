package com.spring.backend.dto;

import lombok.Data;

@Data
public class CardDTO {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolder;
    private UserDTO user;
}
