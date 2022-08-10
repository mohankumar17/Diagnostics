package com.spring.backend.addressservice.service;



import com.spring.backend.addressservice.converter.AddressConverter;
import com.spring.backend.addressservice.dto.AddressDTO;
import com.spring.backend.addressservice.entity.Address;
import com.spring.backend.addressservice.repository.AddressRepository;
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



    @Override
    public List<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addressConverter.addressentitytodto(addresses);
    }

    @Override
    public AddressDTO findById(int theId) {
        Optional<Address> result = addressRepository.findById(theId);
        AddressDTO theAddress = null;
        if (result.isPresent()) {
            theAddress = addressConverter.addressentitytodto(result.get());
        } else {
            return null;
        }
        return theAddress;
    }

    @Override
    public void save(AddressDTO theAddress) {
        Address address = addressConverter.addressdtotoentity(theAddress);
        addressRepository.save(address);
    }
}
