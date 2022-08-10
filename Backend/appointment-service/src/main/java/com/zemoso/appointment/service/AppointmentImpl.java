package com.zemoso.appointment.service;


import com.zemoso.appointment.dto.AppointmentDTO;
import com.zemoso.appointment.entity.Appointment;
import com.zemoso.appointment.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentImpl implements AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentImpl(AppointmentRepository theAppointmentRepository) {
        appointmentRepository = theAppointmentRepository;
    }

    @Override
    public List<AppointmentDTO> findAll() {
        return appointmentRepository.findAll().stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(int theId) {
        Optional<Appointment> result = appointmentRepository.findById(theId);
        AppointmentDTO theAppointment = new AppointmentDTO();
        if (result.isPresent()) {
            theAppointment = modelMapper.map(result.get(), AppointmentDTO.class);
        }
        return theAppointment;
    }

    @Override
    public void save(AppointmentDTO theAppointment) {
        Appointment appointment = modelMapper.map(theAppointment, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(int id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> result = appointmentRepository.findById(id);
        Appointment appointment = null;
        if (result.isPresent()) {
            appointment = result.get();
            appointment.setDate(appointmentDTO.getDate());
            appointment.setDay(appointmentDTO.getDay());
            appointment.setMonth(appointmentDTO.getMonth());
            appointment.setAddressId(appointmentDTO.getAddressId());
            appointment.setTestId(appointmentDTO.getTestId());
            appointment.setLabId(appointmentDTO.getLabId());
            appointment.setUserId(appointment.getUserId());
            appointmentRepository.save(appointment);
        }
        return appointment;
    }

}
