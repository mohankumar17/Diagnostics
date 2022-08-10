package com.zemoso.patient.service;

import com.zemoso.patient.entity.Patient;
import com.zemoso.patient.exception.PatientNotFoundException;
import com.zemoso.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);
        Patient thePatient = null;
        if (result.isPresent()) {
            thePatient = result.get();
        } else {
            throw new PatientNotFoundException("Did not find patient id - " );
        }

        return thePatient;
    }

    @Override
    public void save(Patient thePatient) {
        patientRepository.save(thePatient);
    }

    @Override
    public Patient update(int id, Patient thePatient) {
        Optional<Patient> result = patientRepository.findById(id);
        Patient patient = null;
        if (result.isPresent()) {
            patient = result.get();
            patient.setRelation(thePatient.getRelation());
            patient.setName(thePatient.getName());
            patient.setDob(thePatient.getDob());
            patient.setGender(thePatient.getGender());
            patient.setUserId(thePatient.getUserId());

            patientRepository.save(patient);
        } else {
            throw new PatientNotFoundException("Did not find patient id - " + id);
        }
        return patient;
    }
}
