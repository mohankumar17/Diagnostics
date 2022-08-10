package com.spring.backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;

    public UserDTO() {
        this.id = 0;
    }
}
