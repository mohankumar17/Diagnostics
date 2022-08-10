package com.zemoso.appointment.service;

import com.zemoso.appointment.dto.AppointmentDTO;
import com.zemoso.appointment.entity.Appointment;
import com.zemoso.appointment.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppointmentServiceTest {
    
    @Autowired
    private AppointmentService appointmentService;
    @MockBean
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void findAll() {
        Appointment appointment1 = new Appointment(1,"January","Monday",1,1,1,1,1);
        Appointment appointment2 = new Appointment(1,"January","Monday",1,1,1,1,1);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);
        when(appointmentRepository.findAll()).thenReturn(appointments);
        assertEquals(appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList()), appointmentService.findAll());
    }

    @Test
    void findAppointmentById() {
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        when(appointmentRepository.findById(1)).thenReturn(Optional.of(appointment));
        appointmentService.findById(1000);
        assertEquals(modelMapper.map(appointment, AppointmentDTO.class), appointmentService.findById(1));
    }

    @Test
    void saveAppointment() {
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
        appointmentService.save(appointmentDTO);
        assertEquals("January", appointmentDTO.getMonth());
        assertEquals("Monday", appointmentDTO.getDay());
        assertEquals(1, appointmentDTO.getDate());
    }

    @Test
    void updateAppointment(){
        Appointment appointment = new Appointment(1,"January","Monday",1,1,1,1,1);
        Appointment appointment1 = new Appointment("January","Monday",1,1,1,1,1);
        Appointment appointment2 = new Appointment(1,"January","Monday",1);
        Appointment appointment3 = new Appointment("January","Monday",1);
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
        appointmentService.update(1000,appointmentDTO);
        when(appointmentRepository.findById(1)).thenReturn(Optional.of(appointment));
        Appointment updatedAppointment = appointmentService.update(1, appointmentDTO);
        assertEquals("January", appointmentDTO.getMonth());
        assertEquals("Monday", appointmentDTO.getDay());
        assertEquals(1, appointmentDTO.getDate());
    }
}
