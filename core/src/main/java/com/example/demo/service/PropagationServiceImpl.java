package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PropagationServiceImpl implements PropagationService{

    @Autowired
    private TestService testService;

    @Autowired
    private Test1Service test1Service;


    @Override
    public void testRequiredAndRequiresNew() {
//        testService.reduceAccount(1L, BigDecimal.valueOf(10));
//
//        test1Service.addAccount(2L, BigDecimal.valueOf(10));
    }
}
