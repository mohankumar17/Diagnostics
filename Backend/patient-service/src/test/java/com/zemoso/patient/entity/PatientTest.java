package com.zemoso.patient.entity;


import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientTest {

    @Test
    void userGetterSetterTest() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Revanth");
        patient.setRelation("Myself");
        patient.setDob(new Date(1991, 7, 17));
        patient.setGender("Male");
        patient.setUserId(1);
        assertEquals(1, patient.getId());
        assertEquals("Revanth", patient.getName());
        assertEquals("Myself", patient.getRelation());
        assertEquals(new Date(1991, 7, 17), patient.getDob());
        assertEquals("Male", patient.getGender());
        assertEquals(1, patient.getUserId());
        Patient patient1 = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        Patient patient2 = new Patient("father", "John", new Date(1970, 10, 23), "male", 1);



    }

}
