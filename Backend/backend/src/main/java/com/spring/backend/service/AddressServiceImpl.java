package com.spring.backend.service;

import com.spring.backend.converters.AddressConverter;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.AddressDTO;
import com.spring.backend.entity.Address;
import com.spring.backend.entity.User;
import com.spring.backend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addressConverter.AddressEntityToDto(addresses);
    }

    @Override
    public AddressDTO findById(int theId) {
        Optional<Address> result = addressRepository.findById(theId);
        AddressDTO theAddress = null;
        if (result.isPresent()) {
            theAddress = addressConverter.AddressEntityToDto(result.get());
        } else {
            return null;
        }
        return theAddress;
    }

    @Override
    public void save(AddressDTO theAddress) {
        Address address = addressConverter.AddressDTOToEntity(theAddress);
        User user = userConverter.userDtoToEntity(theAddress.getUser());
        user.add(address);
        addressRepository.save(address);
    }
}
