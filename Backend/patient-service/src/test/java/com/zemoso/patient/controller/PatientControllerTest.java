package com.zemoso.patient.controller;

import com.zemoso.patient.entity.Patient;

import com.zemoso.patient.exception.PatientNotFoundException;
import com.zemoso.patient.service.PatientService;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PatientControllerTest {

    @Autowired
    private PatientController patientController;

    @MockBean
    private PatientService patientService;


    @Test
     void findAllTest() {

        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        Patient patient2 = new Patient(2, "father", "John", new Date(1970, 10, 23), "male", 1);
        patientList.add(patient1);
        patientList.add(patient2);
        when(patientService.findAll()).thenReturn(patientList);
        assertEquals(2, patientController.findAll().size());
    }

    @Test
     void findByIdTest() {
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", 1);
        when(patientService.findById(1)).thenReturn(patient);

        Assert.assertEquals(1, patientController.findById(1).getId());
        Assert.assertEquals("Paul", patientController.findById(1).getName());
    }


}