package com.spring.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class AppointmentDTO {
    private String month;
    private String day;
    private int date;
    private TestDTO test;
    private LabDTO lab;
    private AddressDTO address;
    private List<PatientDTO> patients;
    private UserDTO user;
}
