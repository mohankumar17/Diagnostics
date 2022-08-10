package com.spring.backend.service;

import com.spring.backend.converters.PatientConverter;
import com.spring.backend.converters.UserConverter;
import com.spring.backend.dto.PatientDTO;
import com.spring.backend.entity.Patient;
import com.spring.backend.entity.User;
import com.spring.backend.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientConverter patientConverter;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patientConverter.patientEntityToDto(patients);
    }

    @Override
    public PatientDTO findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);
        PatientDTO thePatient = null;
        if (result.isPresent()) {
            thePatient = patientConverter.patientEntityToDto(result.get());
        } else {
            throw new RuntimeException("Did not find patient id - " + theId);
        }
        return thePatient;
    }

    @Override
    public void save(PatientDTO thePatient) {
        Patient patient = patientConverter.patientDtoToEntity(thePatient);
        User user = userConverter.userDtoToEntity(thePatient.getUser());
        user.add(patient);
        patientRepository.save(patient);
    }

    @Override
    public Patient update(int theId, PatientDTO thePatient) {
        Optional<Patient> result = patientRepository.findById(theId);
        Patient patient = null;
        if (result.isPresent()) {
            patient = result.get();
            patient.setName(thePatient.getName());
            patient.setRelation(thePatient.getRelation());
            patient.setDob(thePatient.getDob());
            patient.setGender(thePatient.getGender());
            User user = userConverter.userDtoToEntity(thePatient.getUser());
            patient.setUser(user);
            patientRepository.save(patient);
        }
        return patient;
    }

    @Override
    public void deleteById(int theId) {
        patientRepository.deleteById(theId);
    }
}
