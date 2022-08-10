package com.spring.backend.controllers;

import com.spring.backend.dto.AppointmentDTO;
import com.spring.backend.entity.*;
import com.spring.backend.exceptions.AppointmentNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.backend.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private ModelMapper modelMapper;

    private AppointmentService appointmentService;

    // constructor injection of service
    @Autowired
    public AppointmentController(AppointmentService theAppointmentService) {
        this.appointmentService = theAppointmentService;
    }

    @GetMapping("/")
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable(name = "id") int id) {
        AppointmentDTO appointment = appointmentService.findById(id);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found!!");
        }
        return appointment;
    }

    @PostMapping("/")
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO appointment) {
        appointmentService.save(appointment);
        return appointment;
    }

    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(@PathVariable int id, @RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentService.update(id, appointmentDTO);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found!!");
        }
        return appointmentDTO;
    }
}
