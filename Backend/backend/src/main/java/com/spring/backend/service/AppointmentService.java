package com.spring.backend.service;

import com.spring.backend.dto.AppointmentDTO;
import com.spring.backend.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    public List<AppointmentDTO> findAll();

    public AppointmentDTO findById(int theId);

    public void save(AppointmentDTO theAppointment);

    public Appointment update(int id, AppointmentDTO appointmentDTO);
}
