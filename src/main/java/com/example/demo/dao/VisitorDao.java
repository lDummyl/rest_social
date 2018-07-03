package com.example.demo.dao;
import com.example.demo.models.Visitor;
import com.example.demo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class VisitorDao {

//    public Visitor findById(int id){
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Visitor.class,id);
//    }

    public void save(Visitor visitor){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(visitor);
        transaction.commit();
        session.close();
    }

    public void delete(Visitor visitor){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(visitor);
        transaction.commit();
        session.close();
    }

    public void update(Visitor visitor){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(visitor);
        transaction.commit();
        session.close();
    }

    public List<Visitor> findAll() {
        List<Visitor> visitors = (List<Visitor>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return visitors;
    }
}
