package com.spring.backend.service;

import com.spring.backend.converters.PatientConverter;
import com.spring.backend.dto.*;
import com.spring.backend.entity.*;
import com.spring.backend.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientConverter patientConverter;

    @Test
    public void saveAppointment() {
        Lab newLab = new Lab(1, "Los Altos Central Lab", 4, 4);
        com.spring.backend.entity.Test newTest = new com.spring.backend.entity.Test(1, "Covid RTPCR", "24 Hours", 1200);
        Address newAddress = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California");
        User newUser = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", newUser);
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Appointment newAppointment = new Appointment(1, "January", "Monday", 1, newLab, newTest, newAddress, newUser, patients);
        AppointmentDTO appointmentDTO = modelMapper.map(newAppointment, AppointmentDTO.class);
        appointmentService.save(appointmentDTO);
    }

    @Test
    public void updateAppointment() {
        Lab newLab = new Lab(1, "Los Altos Central Lab", 4, 4);
        com.spring.backend.entity.Test newTest = new com.spring.backend.entity.Test(1, "Covid RTPCR", "24 Hours", 1200);
        Address newAddress = new Address(1, "2235 California Street  APT#021", "Mountain View California", 114, "Mountain View ,California");
        User newUser = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", newUser);
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Appointment newAppointment = new Appointment(1, "January", "Monday", 1, newLab, newTest, newAddress, newUser, patients);
        AppointmentDTO appointmentDTO = modelMapper.map(newAppointment, AppointmentDTO.class);
        appointmentService.update(1,appointmentDTO);


    }
}
