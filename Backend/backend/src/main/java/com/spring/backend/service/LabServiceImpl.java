package com.spring.backend.service;

import com.spring.backend.dto.LabDTO;
import com.spring.backend.repository.LabRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabRepository labRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LabDTO> findAll() {
        return labRepository.findAll().stream().map(lab -> modelMapper.map(lab, LabDTO.class))
                .collect(Collectors.toList());
    }
}
