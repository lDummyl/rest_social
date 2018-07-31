package com.example.demo.services;

import com.example.demo.dao.Dao;
import com.example.demo.dao.VisitorDao;
import com.example.demo.models.Hibernatable;
import com.example.demo.models.Visitor;

public class VisitorService {

    private VisitorDao visitorDao = new VisitorDao();

    public VisitorService(){
    }

    public void saveVisitor(Visitor visitor){

        visitorDao.save(visitor);
    }
}
