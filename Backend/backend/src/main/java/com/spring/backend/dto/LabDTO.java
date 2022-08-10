package com.spring.backend.dto;

import lombok.Data;

@Data
public class LabDTO {
    private int id;
    private String name;
    private float rating;
    private int slots_available;
}
