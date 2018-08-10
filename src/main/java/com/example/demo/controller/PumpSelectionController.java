package com.example.demo.controller;

import com.example.demo.Selection.UnitSelect;
import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pump-selection")
public class PumpSelectionController {

    private int counter = 0;
    private String unitName;
    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>(){{

//        add(new HashMap<String, String>(){{put ("id", "1"); put ("text", "text0"); }});
//        add(new HashMap<String, String>(){{put ("id", "2"); put ("text", "test1"); }});
//        add(new HashMap<String, String>(){{put ("id", "3"); put ("text", "text3"); }});

    }};

    @GetMapping
    public List<Map<String, String>> list(){
        System.out.println("we're in GetMapping");
        return messages;

    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id){
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {

        System.out.println("we're in GetMapping-id");
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    @PostMapping
    public Map<String, String> create (@RequestBody Map<String,String> message){

        String unitModelName = UnitSelect.getSelectedModel(message);
        message.put("id", String.valueOf(counter++));
        message.put ("text", unitModelName);
        messages.clear();
        messages.add(message);
        System.out.println("we're in PostMapping");
        return message;
    }
    @PutMapping("{id}")
    public Map<String, String> update (@PathVariable String id, @RequestBody Map<String, String> message){
        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id",id);
        System.out.println("we're in PutMapping-id");
        return messageFromDb;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> message = getMessage(id);
        messages.remove(message);
    }
}
