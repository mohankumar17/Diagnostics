package com.spring.backend.service;

import com.spring.backend.dto.PatientDTO;
import com.spring.backend.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<PatientDTO> findAll();

    public PatientDTO findById(int theId);

    public void save(PatientDTO thePatient);

    public Patient update(int theId, PatientDTO thePatient);

    public void deleteById(int theId);
}