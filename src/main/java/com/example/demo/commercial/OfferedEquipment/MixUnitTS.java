package com.example.demo.commercial.OfferedEquipment;

import com.example.demo.commercial.Price;
import com.example.demo.models.Hibernatable;

import javax.persistence.*;

@Entity
@Table(name = "mix_units_ts")
public class MixUnitTS extends MixUnit implements Hibernatable {
    @Id
    private String basic_name;

    private double price;

    private double dn;

    private double kvs;

    private String pump_model;

    private String speed_3;

    private String speed_2;

    public MixUnitTS(){
        super();
    }

    public double getDn() {
        return dn;
    }

    @Override
    public String getBasic_name() {
        return basic_name;
    }

    @Override
    public double getKvs() {
        return kvs;
    }

    @Override
    public boolean isFits(double flow, double presLose) {

        return false;

    }

}
