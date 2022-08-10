package com.spring.backend.controllers;

import com.spring.backend.dto.AddressDTO;
import com.spring.backend.exceptions.AddressNotFoundException;
import com.spring.backend.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private ModelMapper modelMapper;

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<AddressDTO> listAddress() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable(name = "id") int id) {
        AddressDTO address = addressService.findById(id);
        if (address == null) {
            throw new AddressNotFoundException("Address not found!!");
        }
        return address;
    }

    @PostMapping("/")
    public AddressDTO addAddress(@RequestBody AddressDTO addressDTO) {
        addressDTO.setId(0);
        addressService.save(addressDTO);
        return addressDTO;
    }
}
