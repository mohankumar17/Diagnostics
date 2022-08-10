package com.spring.backend.addressservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private int id;
    private String houseNum;
    private String area;
    private int zipcode;
    private String cityState;
    //private UserDTO user;
    private int userId;

    public AddressDTO() {
        this.id = 0;
    }
}
