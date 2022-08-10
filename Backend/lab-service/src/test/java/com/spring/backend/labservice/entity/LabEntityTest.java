package com.spring.backend.labservice.entity;

import com.spring.backend.labservice.VO.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class LabEntityTest {
    @Test
    void userGetterSetterTest() {
        Lab lab = new Lab();
        Lab lab1 = new Lab(1, "Los Altos Central Lab", 4, 4);
        Lab lab2= new Lab("Los Altos Central Lab", 4, 4);
        lab.setId(1);
        lab.setName("Los Altos Central Lab");
        lab.setRating(4);
        lab.setSlotsAvailable(4);
        Lab newLab = new Lab(1,"Los Altos Central Lab", 4 , 4);
        com.spring.backend.labservice.VO.Test newTest = new com.spring.backend.labservice.VO.Test(1, "Covid RTPCR", "24 Hours", 1200);
        Address newAddress = new Address(1, "2235 California Street  APT#021", "Mountain View California",114,"Mountain View ,California");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Appointment appointment1 = new Appointment(1, "January", "Monday", 1,newLab, newTest,newAddress,user,patients );
        Appointment appointment2 = new Appointment(1, "November", "Tuesday", 1,newLab, newTest,newAddress,user,patients );
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);
        lab.setAppointments(appointments);

        assertEquals(1, lab.getId());
        assertEquals("Los Altos Central Lab", lab.getName());
        assertEquals(4, lab.getRating());
        assertEquals(4, lab.getSlotsAvailable());
        assertEquals(appointments, lab.getAppointments());
        lab.toString();

    }
}
