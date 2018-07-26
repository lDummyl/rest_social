package com.example.demo.controller;

import com.example.demo.Configs.MyConfig;
import com.example.demo.hello.Greeting;
import com.example.demo.hello.Schedule;
import com.example.demo.models.GateKeeper;
import com.example.demo.models.Greeter;
import com.example.demo.models.Visitor;
import com.example.demo.services.VisitorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    public static String greetingWay;
    public static final AtomicLong count = new AtomicLong();
    private static VisitorService visitorService = new VisitorService();
    @GetMapping
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "mr. Incognito") String name) {
        Greeting.greetingsPerformedQty = count.incrementAndGet();
        Visitor visitor = new Visitor(name);
        visitorService.saveVisitor(visitor);
        Greeter gtr = Schedule.getPersonOnDuty();
        greetingWay = gtr.getGreeting();
        return new Greeting(visitor.getId(), String.format(greetingWay, name));
    }
}