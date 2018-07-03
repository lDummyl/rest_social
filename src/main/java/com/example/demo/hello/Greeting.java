package com.example.demo.hello;

import com.example.demo.models.Visitor;
import com.example.demo.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Greeting {

    public static long greetingsPerformedQty;
    private final long visitorId;

    private final String content;

    public Greeting(long visitorId,String content){
        this.visitorId = visitorId;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getVisitorId() {
        return visitorId;
    }

    public String getAnnotation() {
        return String.format("Всего %d гостей поприветствовали.", greetingsPerformedQty);
    }

    public static List<Visitor> getAllVisitors (){
        List<Visitor> visitors = (List<Visitor>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Visitor").list();
        return visitors;
    }
}
