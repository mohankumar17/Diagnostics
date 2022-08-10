package com.spring.backend.labservice.controller;


import com.spring.backend.labservice.dto.LabDTO;
import com.spring.backend.labservice.service.LabService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/labs")
@CrossOrigin(origins = "*")
public class LabController {

    @Autowired
    private ModelMapper modelMapper;

    private LabService labService;

    @Autowired
    public LabController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping("/")
    public List<LabDTO> listLabs() {
        return labService.findAll();
    }

}
