package com.zemoso.patient.service;

import com.zemoso.patient.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    Patient findById(int theId);

    void save(Patient thePatient);

    Patient update(int id, Patient thePatient);
}