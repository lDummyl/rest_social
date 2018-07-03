package com.example.demo.controller;

import com.example.demo.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shelf")
public class ShelfController {

    private List<String> pictures = new ArrayList<String>(){{
        add("pictures of cat");
        add("pictures of other cat");
        add("pictures of more cats");
    }};

    @GetMapping
    public List<String> getPictures(){
        return pictures;
    }

    @GetMapping("{id}")
    public String getPic(@PathVariable String id){
        int i = Integer.parseInt(id);
        if (i >= pictures.size()) throw new NotFoundException();
        return pictures.get(Integer.parseInt(id));
    }
}