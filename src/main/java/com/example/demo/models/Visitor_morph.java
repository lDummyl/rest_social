package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitor_morph implements Hibernatable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column//(name = "name")
    private String name;

    public Visitor_morph(){}

    public Visitor_morph(String name){this.name = name;}

    public int getId() {return id;}

    public String getName() {return name;}
}
