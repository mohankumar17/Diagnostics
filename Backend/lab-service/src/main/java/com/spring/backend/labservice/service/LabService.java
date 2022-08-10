package com.spring.backend.labservice.service;


import com.spring.backend.labservice.dto.LabDTO;

import java.util.List;

public interface LabService {
    List<LabDTO> findAll();

}
