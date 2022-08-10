package com.spring.backend.service;

import com.spring.backend.entity.Lab;
import com.spring.backend.repository.LabRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class LabServiceImplTest {
    @MockBean
    private LabRepository labRepository;

    @Autowired
    private LabService labService;

    @Test
    public void findAllTest() {
        Lab lab1 = new Lab(1, "Los Altos Central Lab", 4, 4);
        Lab lab2 = new Lab(2, "Zemoso Diagnostics", 5, 7);
        List<Lab> labList = new ArrayList<>();
        labList.add(lab1);
        labList.add(lab2);
        when(labRepository.findAll()).thenReturn(labList);
        assertEquals(2, labService.findAll().size());
    }

}
