package com.zemoso.user.service;

import com.zemoso.user.converter.UserConverter;
import com.zemoso.user.entity.User;
import com.zemoso.user.exception.UserNotFoundException;
import com.zemoso.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
 class UserServiceImpTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;


    @Test
     void findAll() {
        User user1 = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        User user2 = new User(2, "Patrick Smith", "patrick.smith@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(userConverter.userEntityToDto(userList), userService.findAll());
    }

    @Test
     void findById() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertEquals(1, userService.findById(1).getId());
        assertEquals(userConverter.userEntityToDto(user), userService.findById(1));
    }


    @Test
     void save() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        userService.save(userConverter.userEntityToDto(user));
        assertEquals(1, userService.findById(1).getId());
    }

}
