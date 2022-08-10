package com.zemoso.appointment.controller;

import com.zemoso.appointment.dto.AppointmentDTO;
import com.zemoso.appointment.entity.Appointment;
import com.zemoso.appointment.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppointmentControllerTest {

    @Autowired
    private AppointmentController appointmentController;
    @MockBean
    private AppointmentService appointmentService;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void getAllAppointments(){
        Appointment appointment1 = new Appointment(1,"January","Monday",1,1,1,1,1);
        Appointment appointment2 = new Appointment(1,"January","Monday",1,1,1,1,1);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);
        when(appointmentService.findAll()).thenReturn(appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList()));
        assertEquals(appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList()), appointmentController.getAllAppointments());
    }

    @Test
    void getAppointmentById(){
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        when(appointmentService.findById(1)).thenReturn(modelMapper.map(appointment, AppointmentDTO.class));
        assertEquals(modelMapper.map(appointment, AppointmentDTO.class), appointmentController.getAppointmentById(1));
        try{
            appointmentController.getAppointmentById(1000);
        }catch (Exception e){
            System.out.println("Appointment not found");
        }
    }

    @Test
    void createAppointment(){
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
        appointmentController.createAppointment(appointmentDTO);
        assertEquals("January", appointmentDTO.getMonth());
        assertEquals("Monday", appointmentDTO.getDay());
        assertEquals(1, appointmentDTO.getDate());
    }

    @Test
    void updateAppointment(){
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
        when(appointmentService.update(1, appointmentDTO)).thenReturn(appointment);
        AppointmentDTO updatedAppointment =  appointmentController.updateAppointment(1, appointmentDTO);
        assertEquals("January", updatedAppointment.getMonth());
        assertEquals("Monday", updatedAppointment.getDay());
        assertEquals(1, updatedAppointment.getDate());
        try{
            appointmentController.updateAppointment(1000, appointmentDTO);
        }catch (Exception e){
            System.out.println("Appointment not found");
        }
    }
}
