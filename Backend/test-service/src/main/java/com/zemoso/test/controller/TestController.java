package com.zemoso.test.controller;

import com.zemoso.test.dto.TestDTO;
import com.zemoso.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/")
    public List<TestDTO> findAll() {
        return testService.findAll();
    }
}
