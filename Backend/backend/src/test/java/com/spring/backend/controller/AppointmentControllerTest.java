package com.spring.backend.controller;
import com.spring.backend.controllers.AppointmentController;
import com.spring.backend.converters.PatientConverter;
import com.spring.backend.dto.*;
import com.spring.backend.entity.*;
import com.spring.backend.service.AppointmentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AppointmentControllerTest {

    @MockBean
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentController appointmentController;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PatientConverter patientConverter;

    @Test
    @Order(1)
    public void createAppointment(){
        Lab newLab = new Lab(1,"Los Altos Central Lab", 4 , 4);
        com.spring.backend.entity.Test newTest = new com.spring.backend.entity.Test(1, "Covid RTPCR", "24 Hours", 1200);
        Address newAddress = new Address(1, "2235 California Street  APT#021", "Mountain View California",114,"Mountain View ,California");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Appointment appointment1 = new Appointment(1, "January", "Monday", 1,newLab, newTest,newAddress,user,patients );
        AppointmentDTO appointmentDTO = modelMapper.map(appointment1,AppointmentDTO.class);
        AppointmentDTO appointment = appointmentController.createAppointment(appointmentDTO);
        assertEquals("January", appointment.getMonth());
        assertEquals(1, appointment.getDate());
        assertEquals("Monday", appointment.getDay());
    }

    @Test
    public void updateAppointment(){
        Lab newLab = new Lab(1,"Los Altos Central Lab", 4 , 4);
        com.spring.backend.entity.Test newTest = new com.spring.backend.entity.Test(1, "Covid RTPCR", "24 Hours", 1200);
        Address newAddress = new Address(1, "2235 California Street  APT#021", "Mountain View California",114,"Mountain View ,California");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Appointment appointment1 = new Appointment(1, "January", "Monday", 1,newLab, newTest,newAddress,user,patients );
        Appointment appointment2 = new Appointment(1, "November", "Tuesday", 1,newLab, newTest,newAddress,user,patients );
        AppointmentDTO appointmentDTO2= modelMapper.map(appointment2,AppointmentDTO.class);
        try{
            AppointmentDTO appointment = appointmentController.updateAppointment(1, appointmentDTO2);
            assertEquals("November", appointment.getMonth());
            assertEquals(1, appointment.getDate());
            assertEquals("Tuesday", appointment.getDay());
        }catch (Exception e){
            System.out.println("Appointment not found");
        }
    }
}
