package com.spring.backend.service;

import com.spring.backend.dto.TestDTO;
import java.util.List;

public interface TestService {
    List<TestDTO> findAll();
}