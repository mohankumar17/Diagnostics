package com.spring.backend.service;

import com.spring.backend.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO findById(int theId);

    public void save(UserDTO theUser);

}
