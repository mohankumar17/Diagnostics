package com.spring.backend.service;

import com.spring.backend.converters.PatientConverter;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.AppointmentDTO;
import com.spring.backend.dto.PatientDTO;
import com.spring.backend.entity.*;
import com.spring.backend.repository.AppointmentRepository;
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

    @Autowired
    private PatientConverter patientConverter;

    @Autowired
    private UserConverter userConverter;

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
        Test test = modelMapper.map(theAppointment.getTest(), Test.class);
        test.add(appointment);
        Lab lab = modelMapper.map(theAppointment.getLab(), Lab.class);
        lab.add(appointment);
        Address address = modelMapper.map(theAppointment.getAddress(), Address.class);
        address.add(appointment);
        User user = userConverter.userDtoToEntity(theAppointment.getUser());
        user.add(appointment);
        List<Patient> patients = patientConverter.patientDtoToEntity(theAppointment.getPatients());
        appointment.setPatients(patients);

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
            appointment.setTest(modelMapper.map(appointmentDTO.getTest(), Test.class));
            appointment.setLab(modelMapper.map(appointmentDTO.getLab(), Lab.class));
            appointment.setAddress(modelMapper.map(appointmentDTO.getAddress(), Address.class));
            User user = userConverter.userDtoToEntity(appointmentDTO.getUser());
            appointment.setUser(user);
            appointment.setPatients(patientConverter.patientDtoToEntity(appointmentDTO.getPatients()));

            appointmentRepository.save(appointment);
        }
        return appointment;
    }

}
