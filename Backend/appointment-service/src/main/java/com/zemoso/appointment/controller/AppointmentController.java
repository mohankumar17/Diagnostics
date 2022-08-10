package com.zemoso.appointment.controller;

import com.zemoso.appointment.dto.AppointmentDTO;
import com.zemoso.appointment.entity.Appointment;
import com.zemoso.appointment.exception.AppointmentNotFoundException;
import com.zemoso.appointment.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
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
