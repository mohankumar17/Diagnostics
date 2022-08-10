package com.spring.backend.addressservice.Entity;

import com.spring.backend.addressservice.entity.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {

    @Test
    void userGetterSetterTest() {
        Address address1 = new Address();
        address1.setId(1);
        address1.setArea("2235 California Street  APT#021");
        address1.setCityState("Mountain View ,California");
        address1.setHouseNum("2235 California Street  APT#021");
        address1.setZipcode(114);
        address1.setUserId(1);
        assertEquals(1, address1.getId());
        assertEquals("2235 California Street  APT#021", address1.getArea());
        assertEquals("Mountain View ,California", address1.getCityState());
        assertEquals("2235 California Street  APT#021", address1.getHouseNum());
        assertEquals(114, address1.getZipcode());
        assertEquals(1, address1.getUserId());
        Address address2 = new Address(2, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);
        Address address3= new Address( "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California", 1);


    }

}