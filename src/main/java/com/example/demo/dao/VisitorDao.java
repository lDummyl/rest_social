package com.example.demo.dao;
import com.example.demo.models.Hibernatable;
import com.example.demo.models.Visitor;
import com.example.demo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class VisitorDao extends Dao{

    public Visitor findById (int id) {
        return (Visitor) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Visitor.class, id);
    }

}
