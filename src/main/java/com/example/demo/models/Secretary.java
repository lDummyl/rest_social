package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component("Marika")
public class Secretary {

    private String greeting = "How can I introduce you?";

    public String getGreeting() {
        return greeting;
    }
}
