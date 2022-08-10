package com.spring.backend.addressservice.service;

import com.spring.backend.addressservice.converter.AddressConverter;
import com.spring.backend.addressservice.dto.AddressDTO;
import com.spring.backend.addressservice.entity.Address;
import com.spring.backend.addressservice.repository.AddressRepository;
import com.spring.backend.addressservice.service.AddressServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
 class AddressServiceTest {
    @Autowired
    private AddressServiceImpl addressService;

    @MockBean
    private AddressRepository repository;

    @Autowired
    private AddressConverter addressConverter;

    @Test
    void findAll() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", 1);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        when(repository.findAll()).thenReturn(addressList);
        assertEquals(addressConverter.addressentitytodto(addressList), addressService.findAll());
    }

    @Test
    void findById() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        when(repository.findById(1)).thenReturn(Optional.of(address1));
        assertEquals(addressConverter.addressentitytodto(address1), addressService.findById(1));

    }

    @Test
    void save() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        AddressDTO addressDTO = addressConverter.addressentitytodto(address1);
        addressService.save(addressDTO);
        assertEquals("Mountain View ,California", addressDTO.getCityState());
    }

    @Test
    void AddressEntityToDto() {

        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", 1);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        List<AddressDTO> addressDTOList = addressConverter.addressentitytodto(addressList);

        assertEquals(addressList.get(0).getHouseNum(), addressDTOList.get(0).getHouseNum());
        assertEquals(addressList.get(1).getArea(), addressDTOList.get(1).getArea());
        assertEquals(addressList.get(1).getCityState(), addressDTOList.get(1).getCityState());
    }
    @Test
    void AddressDTOToEntity() {

        AddressDTO address1 = new AddressDTO(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        AddressDTO address2 = new AddressDTO(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", 1);
        List<AddressDTO> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        List<Address> addressDTOList = addressConverter.addressdtotoentity(addressList);

        assertEquals(addressList.get(0).getHouseNum(), addressDTOList.get(0).getHouseNum());
        assertEquals(addressList.get(1).getArea(), addressDTOList.get(1).getArea());
        assertEquals(addressList.get(1).getCityState(), addressDTOList.get(1).getCityState());
    }

}
