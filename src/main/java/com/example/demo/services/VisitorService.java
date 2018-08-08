package com.example.demo.services;

public class VisitorService {

    private VisitorDao visitorDao = new VisitorDao();

    public VisitorService(){
    }

    public void saveVisitor(Visitor visitor){

        visitorDao.save(visitor);
    }
}
