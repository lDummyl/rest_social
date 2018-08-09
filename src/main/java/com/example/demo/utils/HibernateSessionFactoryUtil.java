package com.example.demo.utils;

import com.example.demo.Configs.HiberConfig;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.xml.bind.SchemaOutputResolver;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                HiberConfig.getEntitiesClassesList().forEach(configuration::addAnnotatedClass);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
