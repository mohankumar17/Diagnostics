package com.zemoso.patient.controller;

import com.zemoso.patient.entity.Patient;
import com.zemoso.patient.exception.PatientNotFoundException;
import com.zemoso.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public Patient findById(@PathVariable int patientId) {
        Patient thePatient = patientService.findById(patientId);
        if (thePatient == null) {
            throw new PatientNotFoundException("Patient ID not found");
        }
        return thePatient;
    }

    @PostMapping("/")
    public Patient save(@RequestBody Patient thePatient) {
        patientService.save(thePatient);
        return thePatient;
    }

    @PutMapping("/{patientId}")
    public Patient update(@PathVariable int patientId, @RequestBody Patient thePatient) {
        patientService.update(patientId, thePatient);
        return thePatient;
    }

}