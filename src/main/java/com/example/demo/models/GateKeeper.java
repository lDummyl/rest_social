package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class GateKeeper {

    private String greeting = "Hello to you sire!";

    public String getGreeting() {
        return greeting;
    }
}
