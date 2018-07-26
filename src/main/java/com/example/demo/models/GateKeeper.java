package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class GateKeeper implements Greeter{
    private String name;
    private String greeting = "Hello to you, %s, sire!";
    @Override
    public String getGreeting() {

        if (name != null) {
            greeting = greeting.concat(String.format(" My name is %s, at your service!", name ));
        }
        return greeting;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
