package com.spring.backend.controllers;

import com.spring.backend.dto.UserDTO;
import com.spring.backend.exceptions.UserNotFoundException;
import com.spring.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public UserDTO findById(@PathVariable int userId) {
        UserDTO theUser = userService.findById(userId);
        if (theUser == null) {
            throw new UserNotFoundException("User ID not found");
        }
        return theUser;
    }

    @PostMapping("/")
    public UserDTO save(@RequestBody UserDTO theUser) {
        theUser.setId(0);
        userService.save(theUser);
        return theUser;
    }

}
