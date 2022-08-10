package com.zemoso.user.service;

import com.zemoso.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO findById(int theId);

    public void save(UserDTO theUser);

}
