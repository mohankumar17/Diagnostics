package com.zemoso.user.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {

    @Test
    void userGetterSetterTest() {
        User user = new User();
        User user2 = new User(2, "Parker", "Peterparker@gmail.com");
        user.setId(1);
        user.setName("Revanth");
        user.setEmail("peterparker@gmail.com");
        assertEquals(1, user.getId());
        assertEquals("Revanth", user.getName());
        assertEquals("peterparker@gmail.com", user.getEmail());
        user.toString();

    }

}

