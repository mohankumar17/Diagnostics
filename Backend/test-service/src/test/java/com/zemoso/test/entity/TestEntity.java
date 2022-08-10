package com.zemoso.test.entity;

import com.zemoso.test.TestServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {

    @Test
    void userGetterSetterTest() {
        com.zemoso.test.entity.Test test1 = new com.zemoso.test.entity.Test();
        com.zemoso.test.entity.Test test2 = new com.zemoso.test.entity.Test(1, "Covid RTPCR", "24 Hours", 1200);
        test1.setId(1);
        test1.setName("Covid RTPCR");
        test1.setTime("24 Hours");
        test1.setCost(1200);
        assertEquals(1, test1.getId());
        assertEquals("Covid RTPCR", test1.getName());
        assertEquals("24 Hours", test1.getTime());
        assertEquals(1200, test1.getCost());

    }


}
