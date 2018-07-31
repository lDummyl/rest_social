package com.example.demo.commercial.PurchasingEquipment.Pumps;

import com.example.demo.commercial.Price;
import com.example.demo.commercial.Purchasable;
import com.example.demo.models.Hibernatable;

import javax.persistence.Column;


public abstract class Pump extends Purchasable {


    public String speed_2;
    public String speed_3;

    private int diameterN;
    private String manufactorer;

    @Column(name = "refer")
    private String reference;

    public Price getPrice() {
        return price;
    }

    private Price price;

    public String getReference() {
        return reference;
    }

    public Pump(Price price) {
        price.setItem(this);
        this.price = price;
    }
    public Pump(String ref){
        reference = ref;
    }
    public Pump(){
    }

}
