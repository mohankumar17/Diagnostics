package com.spring.backend.controller;

import com.spring.backend.controllers.AddressController;
import com.spring.backend.converters.AddressConverter;
import com.spring.backend.dto.AddressDTO;
import com.spring.backend.entity.Address;
import com.spring.backend.entity.User;
import com.spring.backend.service.AddressService;
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
public class AddressControllerTest {
    @Autowired
    private AddressController addressController;

    @Autowired
    private AddressConverter addressConverter;

    @MockBean
    private AddressService addressService;

    @Test
    void findAll() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", user);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        when(addressService.findAll()).thenReturn(addressConverter.AddressEntityToDto(addressList));
        assertEquals(addressConverter.AddressEntityToDto(addressList), addressController.listAddress());
    }

    @Test
    void findById() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        when(addressService.findById(1)).thenReturn(addressConverter.AddressEntityToDto(address1));
        assertEquals(addressConverter.AddressEntityToDto(address1), addressController.getAddressById(1));
    }

    @Test
    void findByIdException() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(100, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        when(addressService.findById(1)).thenReturn(addressConverter.AddressEntityToDto(address1));
        when(addressService.findById(100)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> addressController.getAddressById(100));
    }

    @Test
    void save() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        AddressDTO addressDTO = addressConverter.AddressEntityToDto(address1);
        assertEquals("Mountain View California", addressDTO.getArea());
        addressController.addAddress(addressDTO);
    }

}
