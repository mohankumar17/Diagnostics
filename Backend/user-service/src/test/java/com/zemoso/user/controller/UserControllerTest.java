package com.zemoso.user.controller;


import com.zemoso.user.converter.UserConverter;
import com.zemoso.user.dto.UserDTO;
import com.zemoso.user.entity.User;
import com.zemoso.user.exception.UserNotFoundException;
import com.zemoso.user.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
 class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private UserConverter userConverter;



    @Test
     void findAll() {
        User user1 = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        User user2 = new User(2, "Patrick Smith", "patrick.smith@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userService.findAll()).thenReturn(userConverter.userEntityToDto(userList));
        assertEquals(userConverter.userEntityToDto(userList), userController.findAll());
    }

    @Test
     void findById() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userService.findById(1)).thenReturn(userConverter.userEntityToDto(user));

        assertEquals(1, userController.findById(1).getId());
        assertEquals(userConverter.userEntityToDto(user), userController.findById(1));
    }



    @Test
     void save() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        UserDTO newUser = userController.save(userConverter.userEntityToDto(user));

        assertEquals("Paul Brandon", newUser.getName());
    }

}
