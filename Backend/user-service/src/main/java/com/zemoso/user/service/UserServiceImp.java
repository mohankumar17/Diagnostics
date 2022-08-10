package com.zemoso.user.service;

import com.zemoso.user.converter.UserConverter;
import com.zemoso.user.dto.*;
import com.zemoso.user.entity.*;
import com.zemoso.user.exception.UserNotFoundException;
import com.zemoso.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userConverter.userEntityToDto(users);
    }

    @Override
    public UserDTO findById(int theId) {
        Optional<User> result = userRepository.findById(theId);
        UserDTO theUser = null;
        if (result.isPresent()) {
            theUser = userConverter.userEntityToDto(result.get());
        } else {
            throw new UserNotFoundException("Did not find user id - " );
        }
        return theUser;
    }

    @Override
    public void save(UserDTO theUser) {
        User user = userConverter.userDtoToEntity(theUser);
        userRepository.save(user);
    }
}
