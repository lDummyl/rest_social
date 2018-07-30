package com.example.demo.commercial.PurchasingEquipment.Pumps;

import com.example.demo.commercial.Price;
import com.example.demo.commercial.Purchasable;

public abstract class Pump extends Purchasable{

    private int diameterN;
    private String manufactorer;
    private String reference;
    private Price price;


    public Pump(Price price) {
        this.price = price;
    }
}
