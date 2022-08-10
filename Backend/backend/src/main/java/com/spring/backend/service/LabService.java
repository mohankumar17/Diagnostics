package com.spring.backend.service;

import com.spring.backend.dto.LabDTO;

import java.util.List;

public interface LabService {
    List<LabDTO> findAll();

}
