package com.spring.backend.controller;

import com.spring.backend.controllers.UserController;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.UserDTO;
import com.spring.backend.entity.User;
import com.spring.backend.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private UserConverter userConverter;

    @Test
    public void findAllTest() {
        User user1 = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        User user2 = new User(2, "Patrick Smith", "patrick.smith@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userService.findAll()).thenReturn(userConverter.userEntityToDto(userList));
        assertEquals(2, userController.findAll().size());
    }

    @Test
    public void findByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userService.findById(1)).thenReturn(userConverter.userEntityToDto(user));

        Assert.assertEquals(1, userController.findById(1).getId());
        Assert.assertEquals("Paul Brandon", userController.findById(1).getName());
    }

    @Test
    public void findByNonIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userService.findById(1)).thenReturn(userConverter.userEntityToDto(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userController.findById(123).getId();
        });

        String expectedMessage = "User ID not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void saveTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        UserDTO newUser = userController.save(userConverter.userEntityToDto(user));

        Assert.assertEquals("Paul Brandon", newUser.getName());
    }

}
