package com.zemoso.user.controller;

import com.zemoso.user.dto.UserDTO;
import com.zemoso.user.exception.UserNotFoundException;
import com.zemoso.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

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
