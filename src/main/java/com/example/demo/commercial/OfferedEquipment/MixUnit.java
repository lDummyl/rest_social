package com.example.demo.commercial.OfferedEquipment;

import com.example.demo.commercial.PurchasingEquipment.Orderable;
import com.example.demo.commercial.Sellable;

import java.util.ArrayList;
import java.util.List;

public abstract class MixUnit extends Sellable {

    public List<Orderable> elements = new ArrayList<>();

    private String fullName;

    public enum type{HS,TS}

    public abstract double getDn();
    public abstract String getBasic_name();
    public abstract double getKvs();
    public abstract boolean isFits(double flow, double presLose);

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
