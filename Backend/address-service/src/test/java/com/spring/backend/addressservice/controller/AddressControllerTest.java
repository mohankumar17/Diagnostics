package com.spring.backend.addressservice.controller;


import com.spring.backend.addressservice.converter.AddressConverter;
import com.spring.backend.addressservice.dto.AddressDTO;
import com.spring.backend.addressservice.entity.Address;
import com.spring.backend.addressservice.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
 class AddressControllerTest {
    @Autowired
    private AddressController addressController;

    @Autowired
    private AddressConverter addressConverter;

    @MockBean
    private AddressService addressService;

    @Test
    void findAll() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", 1);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        when(addressService.findAll()).thenReturn(addressConverter.addressentitytodto(addressList));
        assertEquals(addressConverter.addressentitytodto(addressList), addressController.listAddress());
    }

    @Test
    void findById() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        when(addressService.findById(1)).thenReturn(addressConverter.addressentitytodto(address1));
        assertEquals(addressConverter.addressentitytodto(address1), addressController.getAddressById(1));
    }

    @Test
    void findByIdException() {

        Address address1 = new Address(100, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        when(addressService.findById(1)).thenReturn(addressConverter.addressentitytodto(address1));
        when(addressService.findById(100)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> addressController.getAddressById(100));
    }

    @Test
    void save() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        AddressDTO addressDTO = addressConverter.addressentitytodto(address1);
        assertEquals("Mountain View California", addressDTO.getArea());
        addressController.addAddress(addressDTO);
    }

}
