package com.example.demo;

import com.example.demo.models.FaceControlSecurity;
import com.example.demo.models.GateKeeper;
import com.example.demo.models.Secretary;
import com.example.demo.models.Visitor;
import com.example.demo.services.VisitorService;
import com.example.demo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    private static  int count = 0;

	public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.example.demo.models");
        GateKeeper gateKeeper = context.getBean(GateKeeper.class);
        Secretary secretary = (Secretary) context.getBean("Marika");
        FaceControlSecurity faceControlSecurity = context.getBean("Fedor", FaceControlSecurity.class);

        System.out.println(gateKeeper.getGreeting());
        System.out.println(secretary.getGreeting());
        System.out.println(faceControlSecurity.getGreeting());
    }
}

