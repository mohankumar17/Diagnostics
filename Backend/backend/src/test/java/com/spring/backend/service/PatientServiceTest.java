package com.spring.backend.service;

import com.spring.backend.converters.PatientConverter;
import com.spring.backend.entity.Patient;
import com.spring.backend.entity.User;
import com.spring.backend.repository.PatientRepository;
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
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientConverter patientConverter;

    @Test
    void findAllTest() {
        List<Patient> patientList = new ArrayList<>();
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient1 = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        Patient patient2 = new Patient(2, "father", "John", new Date(1970, 10, 23), "male", user);
        patientList.add(patient1);
        patientList.add(patient2);
        when(patientRepository.findAll()).thenReturn(patientList);
        assertEquals(2, patientService.findAll().size());
    }

    @Test
    public void findByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Assert.assertEquals(1, patientService.findById(1).getId());
        Assert.assertEquals("Paul", patientService.findById(1).getName());
    }

    @Test
    public void findByNonIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientService.findById(123).getId();
            //Patient ID - 123 doesn't exist, so exception must be thrown
        });

        String expectedMessage = "Did not find patient id - ";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void saveTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        patientService.save(patientConverter.patientEntityToDto(patient));
    }

    @Test
    public void updateTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        patientService.update(1, patientConverter.patientEntityToDto(patient));
    }

    @Test
    public void deleteByIdTest() {
        User user = new User(1, "Paul Brandon", "paul.brandon@gmail.com");
        Patient patient = new Patient(1, "myself", "Paul", new Date(1991, 7, 17), "male", user);
        patientService.deleteById(1);
    }

}