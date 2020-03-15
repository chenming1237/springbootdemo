package com.example.demo.service;

import com.example.demo.AbstractTest;
import com.example.demo.domain.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenming
 * @date 2020/3/15 0015
 */


public class ServiceImplTest extends AbstractTest {

    @Autowired
    private TestService testService;

    @Test
    public void testFindList(){
        List<UserAccount> list = testService.findList();
        System.out.println(list);
    }
}


