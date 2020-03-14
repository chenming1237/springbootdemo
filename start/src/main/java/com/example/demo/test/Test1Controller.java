package com.example.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenming
 * @date 2020/3/14 0014
 */
@RestController
public class Test1Controller {

    @GetMapping("/test1")
    public String get(){
        return "ok";
    }
}
