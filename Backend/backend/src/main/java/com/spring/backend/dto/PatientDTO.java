package com.spring.backend.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PatientDTO {
    private int id;
    private String relation;
    private String name;
    private Date dob;
    private String gender;
    private UserDTO user;

    public PatientDTO() {
        this.id = 0;
    }
}