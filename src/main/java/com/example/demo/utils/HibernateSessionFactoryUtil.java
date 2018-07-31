package com.example.demo.utils;

import com.example.demo.Configs.HiberConfig;
import com.example.demo.commercial.PurchasingEquipment.Pumps.IMP_Pump;
import com.example.demo.models.Visitor;
import com.example.demo.models.Visitor_morph;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();

                HiberConfig.entitiesClassesList.forEach(configuration::addAnnotatedClass);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
