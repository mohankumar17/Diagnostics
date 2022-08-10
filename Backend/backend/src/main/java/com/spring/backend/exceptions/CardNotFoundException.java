package com.spring.backend.exceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String message) {
        super(message);
    }
}
