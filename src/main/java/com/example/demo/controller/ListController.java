package com.example.demo.controller;


import com.example.demo.hello.Greeting;
import com.example.demo.models.Visitor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visitors")

    public class ListController {

    @GetMapping
    public List<Visitor> getList() {
        return Greeting.getAllVisitors();
    }
}

