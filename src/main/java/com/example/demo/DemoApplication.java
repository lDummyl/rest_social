package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Start!");

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("context.xml");


    }
}

