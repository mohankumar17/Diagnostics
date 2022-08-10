package com.spring.backend.exceptions;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
