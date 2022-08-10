package com.zemoso.patient.service;


import com.zemoso.patient.entity.Patient;

import com.zemoso.patient.exception.PatientNotFoundException;
import com.zemoso.patient.repository.PatientRepository;
import com.zemoso.patient.service.PatientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest{

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;



    @Test
    void findAllTest() {
        List<Patient> patientList = new ArrayList<>();

        Patient patient1 = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        Patient patient2 = new Patient(2, "father", "John", new Date(1970, 10, 23), "male", 1);
        patientList.add(patient1);
        patientList.add(patient2);
        when(patientRepository.findAll()).thenReturn(patientList);
        assertEquals(2, patientService.findAll().size());
    }

    @Test
     void findByIdTest() {

        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Assert.assertEquals(1, patientService.findById(1).getId());
        Assert.assertEquals("Paul", patientService.findById(1).getName());
    }



    @Test
     void saveTest() {

        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        patientService.save(patient);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        Assert.assertEquals(1, patientService.findById(1).getId());
        Assert.assertEquals("Paul", patientService.findById(1).getName());
    }

    @Test
     void updateTest() {

        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        patientService.update(1, patient);
        Assert.assertEquals(1, patientService.findById(1).getId());
        Assert.assertEquals("Paul", patientService.findById(1).getName());
    }

}