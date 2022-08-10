package com.spring.backend.converters;

import com.spring.backend.dto.PatientDTO;
import com.spring.backend.dto.UserDTO;
import com.spring.backend.entity.Patient;
import com.spring.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientConverter {

    @Autowired
    private UserConverter userConverter;

    public PatientDTO patientEntityToDto(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setRelation(patient.getRelation());
        patientDTO.setName(patient.getName());
        patientDTO.setDob(patient.getDob());
        patientDTO.setGender(patient.getGender());
        UserDTO userDTO = userConverter.userEntityToDto(patient.getUser());
        patientDTO.setUser(userDTO);
        return patientDTO;
    }

    public List<PatientDTO> patientEntityToDto(List<Patient> patientList) {
        return patientList.stream().map(x -> patientEntityToDto(x)).collect(Collectors.toList());
    }

    public Patient patientDtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setRelation(patientDTO.getRelation());
        patient.setName(patientDTO.getName());
        patient.setDob(patientDTO.getDob());
        patient.setGender(patientDTO.getGender());
        User user = userConverter.userDtoToEntity(patientDTO.getUser());
        patient.setUser(user);
        return patient;
    }

    public List<Patient> patientDtoToEntity(List<PatientDTO> patientDTOList) {
        return patientDTOList.stream().map(x -> patientDtoToEntity(x)).collect(Collectors.toList());
    }

}
