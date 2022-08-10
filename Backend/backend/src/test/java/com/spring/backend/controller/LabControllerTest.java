package com.spring.backend.controller;

import com.spring.backend.controllers.LabController;
import com.spring.backend.dto.LabDTO;
import com.spring.backend.entity.Lab;
import com.spring.backend.service.LabService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LabControllerTest {
    @Autowired
    private LabController labController;

    @MockBean
    private LabService labService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void findAll() {
        Lab lab1 = new Lab(1, "Los Altos Central Lab", 4, 4);
        Lab lab2 = new Lab(2, "Zemoso Diagnostics", 5, 7);
        List<Lab> labList = new ArrayList<>();
        labList.add(lab1);
        labList.add(lab2);

        List<LabDTO> labDTOList = labList.stream().map(lab -> modelMapper.map(lab, LabDTO.class))
                .collect(Collectors.toList());

        when(labService.findAll()).thenReturn(labDTOList);
        assertEquals(2, labController.listLabs().size());
    }

}
