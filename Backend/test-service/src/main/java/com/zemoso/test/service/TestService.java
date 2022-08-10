package com.zemoso.test.service;

import com.zemoso.test.dto.TestDTO;

import java.util.List;

public interface TestService {
    List<TestDTO> findAll();
}