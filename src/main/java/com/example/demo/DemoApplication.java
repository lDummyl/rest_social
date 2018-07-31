package com.example.demo;

import com.example.demo.Configs.MyConfig;
import com.example.demo.Quoter.Quoter;
import com.example.demo.Quoter.TerminatorQuoter;
import com.example.demo.commercial.Currency;
import com.example.demo.commercial.Price;
import com.example.demo.commercial.PurchasingEquipment.Pumps.IMP_Pump;
import com.example.demo.commercial.PurchasingEquipment.Pumps.Pump;
import com.example.demo.dao.Dao;
import com.example.demo.dao.PumpDao;
import com.example.demo.dao.VisitorDao;
import com.example.demo.models.*;
import com.example.demo.services.VisitorService;
import com.example.demo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Start!");
//        System.out.println(new Dao().findAll(Visitor.class));

        System.out.println(new Dao().findAll(IMP_Pump.class));


//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("context.xml");



//        List<Hibernatable> all = new PumpDao().findAll();
//        for (Hibernatable hibernatable : all) {
//            System.out.println(hibernatable);
//        }





    }
}

