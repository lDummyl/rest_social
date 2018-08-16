package com.example.demo.commercial.PurchasingEquipment;

import com.example.demo.constructor.SpecElement;
import com.example.demo.models.Hibernatable;

import javax.persistence.*;

@Entity
@Table(name = "fittings")
public class Fitting implements Hibernatable{

    public enum essences{
        tee,
        shutterValve,
        filter,
        returnValve,
        americanConnection,
        nipple,
        threadedPipe}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String ref;
    public String name;
    public String essence = essences.americanConnection.name();
    public Double dn_main;//might be null
    public Double dn_second;//might be null
    public Double kvs;//might be null
    public double price;
    public String supplier; // TODO: 16.08.2018 switch to supplier Class

    public Fitting() {
    }

    public void setEssence(essences essence) {
        this.essence = essence.name();
    }
}
