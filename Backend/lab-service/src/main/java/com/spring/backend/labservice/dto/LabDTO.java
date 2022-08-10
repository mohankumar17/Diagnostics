package com.spring.backend.labservice.dto;

import lombok.Data;

@Data
public class LabDTO {
    private int id;
    private String name;
    private float rating;
    private int slotsAvailable;
}