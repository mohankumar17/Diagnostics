package com.spring.backend.service;

import com.spring.backend.entity.Test;
import com.spring.backend.repository.TestRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;

    @MockBean
    private TestRepository testRepository;

    @org.junit.jupiter.api.Test
    public void getTest() {
        Test test1 = new Test(1, "Covid RTPCR", "24 Hours", 1200);
        assertEquals(1, test1.getId());
        assertEquals("Covid RTPCR", test1.getName());
        assertEquals("24 Hours", test1.getTime());
        assertEquals(1200, test1.getCost());

        when(testRepository.findAll()).thenReturn(
                Stream.of(test1).collect(Collectors.toList()));
        assertEquals(1, testService.findAll().size());
    }

    @org.junit.jupiter.api.Test
    public void findAllTest() {
        List<Test> testsList = new ArrayList<>();
        Test test1 = new Test(1, "Covid RTPCR", "24 Hours", 1200);
        Test test2 = new Test(2, "Full Body", "24 Hours", 1400);
        testsList.add(test1);
        testsList.add(test2);
        when(testRepository.findAll()).thenReturn(testsList);
        assertEquals(2, testService.findAll().size());
    }

}

