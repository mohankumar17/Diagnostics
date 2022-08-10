package com.spring.backend.service;

import com.spring.backend.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    public List<AddressDTO> findAll();

    public AddressDTO findById(int theId);

    public void save(AddressDTO address);
}
