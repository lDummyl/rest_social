package com.example.demo.commercial.PurchasingEquipment.Pumps;

import com.example.demo.commercial.Price;
import com.example.demo.models.Hibernatable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "pumps")
public class IMP_Pump extends Pump implements Hibernatable {

    @Override
    public Price getPrice() {
        return super.getPrice();
    }

    public IMP_Pump(Price price) {
        super(price);
    }
}
