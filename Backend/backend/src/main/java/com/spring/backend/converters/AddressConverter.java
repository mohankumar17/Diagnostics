package com.spring.backend.converters;

import com.spring.backend.dto.AddressDTO;
import com.spring.backend.dto.UserDTO;
import com.spring.backend.entity.Address;
import com.spring.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    @Autowired
    private UserConverter userConverter;

    public AddressDTO AddressEntityToDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setHouseNum(address.getHouseNum());
        addressDTO.setArea(address.getArea());
        addressDTO.setZipcode(address.getZipcode());
        addressDTO.setCityState(address.getCityState());
        UserDTO userDTO = userConverter.userEntityToDto(address.getUser());
        addressDTO.setUser(userDTO);
        return addressDTO;
    }

    public List<AddressDTO> AddressEntityToDto(List<Address> AddressList) {
        return AddressList.stream().map(x -> AddressEntityToDto(x)).collect(Collectors.toList());
    }

    public Address AddressDTOToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setHouseNum(addressDTO.getHouseNum());
        address.setArea(addressDTO.getArea());
        address.setZipcode(addressDTO.getZipcode());
        address.setCityState(addressDTO.getCityState());
        User user = userConverter.userDtoToEntity(addressDTO.getUser());
        address.setUser(user);
        return address;
    }

    public List<Address> AddressDTOToEntity(List<AddressDTO> AddressDTOList) {
        return AddressDTOList.stream().map(x -> AddressDTOToEntity(x)).collect(Collectors.toList());
    }

}