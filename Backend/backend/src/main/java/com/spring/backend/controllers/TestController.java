package com.spring.backend.controllers;

import com.spring.backend.dto.TestDTO;
import com.spring.backend.service.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private ModelMapper modelMapper;

    private TestService testService;

    @Autowired
    public TestController(TestService theTestService) {
        testService = theTestService;
    }

    @GetMapping("/")
    public List<TestDTO> findAll() {
        return testService.findAll();
    }
}
