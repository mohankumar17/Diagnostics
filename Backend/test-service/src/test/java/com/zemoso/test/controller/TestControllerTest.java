package com.zemoso.test.controller;


import com.zemoso.test.dto.TestDTO;
import com.zemoso.test.entity.Test;
import com.zemoso.test.service.TestService;
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
class TestControllerTest {

    @MockBean
    private TestService testService;

    @Autowired
    private TestController testController;

    @Autowired
    private ModelMapper modelMapper;



    @org.junit.jupiter.api.Test
    void findAllTest() {
        List<Test> testsList = new ArrayList<>();
        Test test1 = new Test(1, "Covid RTPCR", "24 Hours", 1200);
        Test test2 = new Test(2, "Full Body", "24 Hours", 1400);
        testsList.add(test1);
        testsList.add(test2);

       final String name = "Name";
       final String cost= "cost";

        List<TestDTO> testDTOList = testsList.stream().map(test -> modelMapper.map(test, TestDTO.class))
                .collect(Collectors.toList());

        when(testService.findAll()).thenReturn(testDTOList);
        assertEquals(2, testController.findAll().size());
    }

}
