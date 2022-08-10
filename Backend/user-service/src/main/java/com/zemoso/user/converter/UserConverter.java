package com.zemoso.user.converter;

import com.zemoso.user.dto.UserDTO;
import com.zemoso.user.entity.User;
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
        return userList.stream().map(this::userEntityToDto).collect(Collectors.toList());
    }

    public User userDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public List<User> userDtoToEntity(List<UserDTO> userDTOList) {
        return userDTOList.stream().map(this::userDtoToEntity).collect(Collectors.toList());
    }
}
