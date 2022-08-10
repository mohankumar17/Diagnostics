package com.spring.backend.service;

import com.spring.backend.converters.AddressConverter;
import com.spring.backend.converters.PatientConverter;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.*;
import com.spring.backend.entity.*;
import com.spring.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PatientConverter patientConverter;

    @Autowired
    private AddressConverter addressConverter;

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
            throw new RuntimeException("Did not find user id - " + theId);
        }
        return theUser;
    }

    @Override
    public void save(UserDTO theUser) {
        User user = userConverter.userDtoToEntity(theUser);
        userRepository.save(user);
    }
}
