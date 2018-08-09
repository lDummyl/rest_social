package com.example.demo.commercial.OfferedEquipment;

import com.example.demo.Configs.HiberConfig;
import com.example.demo.Selection.Calculations;
import com.example.demo.models.Hibernatable;

import javax.persistence.*;

@Entity
@Table(name = "mix_units_hs")
public class MixUnitHS extends MixUnit implements Hibernatable {

    @Id
    private String basic_name;

    private double price;

    private double dn;

    private double kvs;

    @Transient
    private double maxDifferentialPressure = 6.; //meters

    public MixUnitHS() {
    }

    @Override
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
    public boolean isFits(double flow, double presLose){

        boolean isFits;
        double valvePresLose = Calculations.getPresLose(flow,kvs);
        isFits =(valvePresLose < maxDifferentialPressure)? true: false;
        return isFits;


    }

}
