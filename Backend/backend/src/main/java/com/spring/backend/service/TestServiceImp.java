package com.spring.backend.service;

import com.spring.backend.dto.TestDTO;
import com.spring.backend.repository.TestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TestDTO> findAll() {
        return testRepository.findAll().stream().map(test -> modelMapper.map(test, TestDTO.class))
                .collect(Collectors.toList());

    }
}
