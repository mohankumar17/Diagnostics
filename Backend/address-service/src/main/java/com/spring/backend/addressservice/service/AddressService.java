package com.spring.backend.addressservice.service;

import com.spring.backend.addressservice.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    public List<AddressDTO> findAll();

    public AddressDTO findById(int theId);

    public void save(AddressDTO address);
}
