package com.example.demo.controller;


import com.example.demo.domain.UserAccount;
import com.example.demo.service.PropagationService;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private PropagationService propagationService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public String test(){
        return "test ok";
    }

    @RequestMapping("/getList")
    public List<UserAccount> getList(){
        return testService.findList();
    }

    @RequestMapping("/testSpringTransactionPropagation")
    public void testSpringTransactionPropagation(){
        testService.transfer(1L, 2L, BigDecimal.valueOf(10));
    }
}
