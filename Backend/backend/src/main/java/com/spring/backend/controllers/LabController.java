package com.spring.backend.controllers;

import com.spring.backend.dto.LabDTO;
import com.spring.backend.service.LabService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/labs")
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
