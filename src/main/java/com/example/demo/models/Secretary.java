package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component("Marika")
public class Secretary implements Greeter{

    private String greeting = "Hello, %s, how can I help you?";
    @Override
    public String getGreeting() {
        return greeting;
    }
}
