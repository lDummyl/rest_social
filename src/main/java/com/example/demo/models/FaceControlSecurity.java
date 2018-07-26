package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component("Fedor")
public class FaceControlSecurity implements Greeter{

    @Override
    public String getGreeting() {
        return greeting;
    }

    private String greeting = "%s? You're not on the list!";

}
