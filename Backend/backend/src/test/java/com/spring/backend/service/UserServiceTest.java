package com.spring.backend.service;

import com.spring.backend.converters.UserConverter;
import com.spring.backend.entity.User;
import com.spring.backend.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Test
    public void findAllTest() {
        User user1 = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        User user2 = new User(2, "Patrick Smith", "patrick.smith@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(2, userService.findAll().size());
    }

    @Test
    public void findByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Assert.assertEquals(1, userService.findById(1).getId());
        Assert.assertEquals("Paul Brandon", userService.findById(1).getName());
    }

    @Test
    public void findByNonIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.findById(123).getId();
        });

        String expectedMessage = "Did not find user id - ";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void saveTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        userService.save(userConverter.userEntityToDto(user));
    }

}
