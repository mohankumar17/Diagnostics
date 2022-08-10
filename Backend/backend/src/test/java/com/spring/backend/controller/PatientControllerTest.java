package com.spring.backend.controller;

import com.spring.backend.controllers.PatientController;
import com.spring.backend.converters.PatientConverter;
import com.spring.backend.dto.PatientDTO;
import com.spring.backend.entity.Patient;
import com.spring.backend.entity.User;
import com.spring.backend.service.PatientService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientControllerTest {

    @Autowired
    private PatientController patientController;

    @MockBean
    private PatientService patientService;

    @Autowired
    private PatientConverter patientConverter;

    @Test
    public void findAllTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        Patient patient2 = new Patient(2, "father", "John", new Date(1970, 10, 23), "male", user);
        patientList.add(patient1);
        patientList.add(patient2);
        when(patientService.findAll()).thenReturn(patientConverter.patientEntityToDto(patientList));
        assertEquals(2, patientController.findAll().size());
    }

    @Test
    public void findByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        when(patientService.findById(1)).thenReturn(patientConverter.patientEntityToDto(patient));

        Assert.assertEquals(1, patientController.findById(1).getId());
        Assert.assertEquals("Paul", patientController.findById(1).getName());
    }

    @Test
    public void findByNonIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        when(patientService.findById(1)).thenReturn(patientConverter.patientEntityToDto(patient));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientController.findById(123).getId();
            //Patient ID - 123 doesn't exist, so exception must be thrown
        });

        String expectedMessage = "Patient ID not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void saveTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(0, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        PatientDTO newPatient = patientController.save(patientConverter.patientEntityToDto(patient));

        Assert.assertEquals("Paul", newPatient.getName());
    }

    @Test
    public void updateTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        PatientDTO patientDTO = patientConverter.patientEntityToDto(patient);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientController.update(123, patientDTO);
            //Patient ID - 123 doesn't exist, so exception must be thrown
        });

        String expectedMessage = "Patient id not found - 123";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void deleteByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(0, "myself", "Paul", new Date(1991, 7, 17), "male", user);

        PatientDTO newPatient = patientController.save(patientConverter.patientEntityToDto(patient));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientController.deleteById(123);
        });
        String expectedMessage = "Patient id not found - 123";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}