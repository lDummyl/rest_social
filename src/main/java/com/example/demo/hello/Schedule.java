package com.example.demo.hello;

import com.example.demo.Configs.MyConfig;
import com.example.demo.models.FaceControlSecurity;
import com.example.demo.models.GateKeeper;
import com.example.demo.models.Greeter;
import com.example.demo.models.Secretary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Schedule {

    public static Greeter getPersonOnDuty() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        switch (dayOfWeek) {
            case MONDAY:
                return (Secretary) context.getBean("Marika");
            case TUESDAY:
                return (FaceControlSecurity) context.getBean("Fedor");
            case WEDNESDAY:
                return (GateKeeper) context.getBean("Barry");
            case THURSDAY:
                return (Secretary) context.getBean("Marika");
            case FRIDAY:
                return (GateKeeper) context.getBean("Barry");
            case SATURDAY:
                return (FaceControlSecurity) context.getBean("Fedor");
            case SUNDAY:
                return (FaceControlSecurity) context.getBean("Fedor");
        }
        return null;
    }
}