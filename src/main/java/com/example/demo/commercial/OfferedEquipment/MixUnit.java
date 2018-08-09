package com.example.demo.commercial.OfferedEquipment;

import com.example.demo.commercial.Price;
import com.example.demo.commercial.Sellable;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class MixUnit extends Sellable {

     public enum type{HS,TS}

     public abstract double getDn();
     public abstract String getBasic_name();
     public abstract double getKvs();
     public abstract boolean isFits(double flow, double presLose);

}
