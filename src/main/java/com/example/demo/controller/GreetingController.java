package com.example.demo.controller;

import com.example.demo.hello.Greeting;
import com.example.demo.models.Visitor;
import com.example.demo.services.VisitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    public static final String template = "Hi, %s!";
    public static final AtomicLong count = new AtomicLong();

    private static VisitorService visitorService = new VisitorService();

    @GetMapping
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "There") String name) {
        Greeting.greetingsPerformedQty = count.incrementAndGet();
        Visitor visitor = new Visitor(name);
        visitorService.saveVisitor(visitor);
//        return new Greeting(count.get(), String.format(template, name));
        return new Greeting(visitor.getId(), String.format(template, name));
    }
}