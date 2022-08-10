package com.zemoso.appointment.dto;

import lombok.Data;

@Data
public class AppointmentDTO {
    private int id;
    private String month;
    private String day;
    private int date;
    private int testId;
    private int labId;
    private int addressId;
    private int userId;
}
