package com.spring.backend.converters;

import com.spring.backend.dto.UserDTO;
import com.spring.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDTO userEntityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public List<UserDTO> userEntityToDto(List<User> userList) {
        return userList.stream().map(x -> userEntityToDto(x)).collect(Collectors.toList());
    }

    public User userDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public List<User> userDtoToEntity(List<UserDTO> userDTOList) {
        return userDTOList.stream().map(x -> userDtoToEntity(x)).collect(Collectors.toList());
    }
}
