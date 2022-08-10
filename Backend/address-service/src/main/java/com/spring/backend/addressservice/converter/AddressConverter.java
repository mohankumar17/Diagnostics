package com.spring.backend.addressservice.converter;



import com.spring.backend.addressservice.dto.AddressDTO;
import com.spring.backend.addressservice.entity.Address;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {



    public AddressDTO addressentitytodto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setHouseNum(address.getHouseNum());
        addressDTO.setArea(address.getArea());
        addressDTO.setZipcode(address.getZipcode());
        addressDTO.setCityState(address.getCityState());
        addressDTO.setUserId(address.getUserId());
        return addressDTO;
    }

    public List<AddressDTO> addressentitytodto(List<Address> addressList) {
        return addressList.stream().map(this::addressentitytodto).collect(Collectors.toList());
    }

    public Address addressdtotoentity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setHouseNum(addressDTO.getHouseNum());
        address.setArea(addressDTO.getArea());
        address.setZipcode(addressDTO.getZipcode());
        address.setCityState(addressDTO.getCityState());
        address.setUserId(addressDTO.getUserId());
        return address;
    }

    public List<Address> addressdtotoentity(List<AddressDTO> addressdtoList) {
        return addressdtoList.stream().map(this::addressdtotoentity).collect(Collectors.toList());
    }

}
