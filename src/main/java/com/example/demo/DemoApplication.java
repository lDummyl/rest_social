package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);

        System.out.println("Start!");
//
////        System.out.println(new Dao().findAll(Visitor.class));
//        System.out.println(new Dao().findAll(IMP_Pump.class));
//
//        new Dao().save(new Visitor("Vova"));
//        new Dao().save(new IMP_Pump());

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("context.xml");


    }
}

