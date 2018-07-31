package com.example.demo.dao;

import com.example.demo.models.Hibernatable;
import com.example.demo.models.Visitor;
import com.example.demo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class Dao {


    public void save(Hibernatable hib){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(hib);
        transaction.commit();
        session.close();
    }

    public void delete(Hibernatable hib){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(hib);
        transaction.commit();
        session.close();
    }

    public void update(Hibernatable hib){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(hib);
        transaction.commit();
        session.close();
    }

    public static List<Hibernatable> findAll(Class cl) {
        List<Hibernatable> list;

        String query = "From ";
        query = query.concat(cl.getSimpleName());

        list = (List<Hibernatable>)  HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery(query).list();
        return list;
    }
}
