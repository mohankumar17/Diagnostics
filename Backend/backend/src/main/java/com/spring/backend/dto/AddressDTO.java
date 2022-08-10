package com.spring.backend.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private int id;
    private String houseNum;
    private String area;
    private int zipcode;
    private String cityState;
    private UserDTO user;

    public AddressDTO() {
        this.id = 0;
    }
}
