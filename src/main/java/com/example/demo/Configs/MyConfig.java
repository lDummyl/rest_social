package com.example.demo.Configs;

import com.example.demo.models.FaceControlSecurity;
import com.example.demo.models.GateKeeper;
import com.example.demo.models.Secretary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean("Fedor")
    public FaceControlSecurity getFaceControlSecurity(){
        return new FaceControlSecurity();
    }

    @Bean("Barry")
    public GateKeeper getGateKeeper(){
        GateKeeper barry = new GateKeeper();
        barry.setName("Barrymore");
        return barry;
    }
    @Bean("Marika")
    public Secretary getSecretary(){
        return new Secretary();
    }





}
