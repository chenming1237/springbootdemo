package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenming
 * @date 2020/3/15 0015
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbstractTest.TestApplication.class)
public class AbstractTest {


    @SpringBootApplication
    public static class TestApplication{
        public static void main(String[] args) {
            System.out.println("启动spring");
        }
    }

    @Test
    public void test(){
        System.out.println("sss");
    }
}
