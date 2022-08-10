package com.spring.backend.controllers;

import com.spring.backend.dto.PatientDTO;
import com.spring.backend.exceptions.PatientNotFoundException;
import com.spring.backend.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private ModelMapper modelMapper;

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService thePatientService) {
        this.patientService = thePatientService;
    }

    @GetMapping("/")
    public List<PatientDTO> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public PatientDTO findById(@PathVariable int patientId) {
        PatientDTO thePatient = patientService.findById(patientId);
        if (thePatient == null) {
            throw new PatientNotFoundException("Patient ID not found");
        }
        return thePatient;
    }

    @PostMapping("/")
    public PatientDTO save(@RequestBody PatientDTO thePatient) {
        thePatient.setId(0);
        patientService.save(thePatient);
        return thePatient;
    }

    @PutMapping("/{patientId}")
    public PatientDTO update(@PathVariable int patientId, @RequestBody PatientDTO thePatient) {
        PatientDTO tempPatient = patientService.findById(patientId);
        if (tempPatient == null) {
            throw new PatientNotFoundException("Patient id not found - " + patientId);
        }
        patientService.update(patientId, thePatient);
        return thePatient;
    }

    @DeleteMapping("/{patientId}")
    public String deleteById(@PathVariable int patientId) {
        PatientDTO tempPatient = patientService.findById(patientId);
        if (tempPatient == null) {
            throw new PatientNotFoundException("Patient id not found - " + patientId);
        }
        patientService.deleteById(patientId);
        return "Deleted patient id - " + patientId;
    }
}