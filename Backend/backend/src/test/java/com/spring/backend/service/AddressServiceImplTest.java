package com.spring.backend.service;

import com.spring.backend.converters.AddressConverter;
import com.spring.backend.dto.AddressDTO;
import com.spring.backend.entity.Address;
import com.spring.backend.entity.User;
import com.spring.backend.repository.AddressRepository;
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
public class AddressServiceImplTest {
    @Autowired
    private AddressServiceImpl addressService;

    @MockBean
    private AddressRepository repository;

    @Autowired
    private AddressConverter addressConverter;

    @Test
    void findAll() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", user);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        when(repository.findAll()).thenReturn(addressList);
        assertEquals(addressConverter.AddressEntityToDto(addressList), addressService.findAll());
    }

    @Test
    void findById() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        when(repository.findById(1)).thenReturn(Optional.of(address1));
        assertEquals(addressConverter.AddressEntityToDto(address1), addressService.findById(1));

    }

    @Test
    void save() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        AddressDTO addressDTO = addressConverter.AddressEntityToDto(address1);
        addressService.save(addressDTO);
        assertEquals("Mountain View ,California", addressDTO.getCityState());
    }

    @Test
    void entityToDtoTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Address address1 = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", user);
        Address address2 = new Address(2, "3-2-3", "Bigbazar", 502110, "Medak, Telangana", user);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        List<AddressDTO> addressDTOList = addressConverter.AddressEntityToDto(addressList);

        assertEquals(addressList.get(0).getHouseNum(), addressDTOList.get(0).getHouseNum());
        assertEquals(addressList.get(1).getArea(), addressDTOList.get(1).getArea());
        assertEquals(addressList.get(1).getCityState(), addressDTOList.get(1).getCityState());
    }

}
