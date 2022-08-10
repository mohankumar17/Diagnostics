package com.zemoso.appointment.service;

import com.zemoso.appointment.dto.AppointmentDTO;
import com.zemoso.appointment.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    public List<AppointmentDTO> findAll();

    public AppointmentDTO findById(int theId);

    public void save(AppointmentDTO theAppointment);

    public Appointment update(int id, AppointmentDTO appointmentDTO);
}
