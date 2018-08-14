package com.example.demo.constructor;

import com.example.demo.commercial.PurchasingEquipment.Manufactorerers.Manufactorer;
import com.example.demo.commercial.PurchasingEquipment.Suppliers.Supplier;

public class SpecElement {

    String art;
    String name;
    double dnMain;
    double dnSecondary;
    double kvs;
    Supplier supplier;
    Manufactorer manufactorer;

    public SpecElement() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpecElement other = (SpecElement) obj;
        if (!art.equals(other.art))
            return false;
        if (!name.equals(other.name))
            return false;
        if (!supplier.equals(other.supplier))
            return false;
        if (!manufactorer.equals(other.manufactorer))
            return false;
        if (kvs != other.kvs)
            return false;
        if (dnMain != other.dnMain)
            return false;
        if (dnSecondary != other.dnSecondary)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)dnMain;
        result = prime * result + (int)dnSecondary;
        result = prime * result + (int)kvs;
        if (art !=null)
        result = prime * result + art.hashCode();
        if (name !=null)
        result = prime * result + name.hashCode();
        if (supplier !=null)
        result = prime * result + supplier.hashCode();
        if (manufactorer !=null)
        result = prime * result + manufactorer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SpecElement{" +
                "art='" + art + '\'' +
                ", name='" + name + '\'' +
                ", dnMain=" + dnMain +
                ", dnSecondary=" + dnSecondary +
                ", kvs=" + kvs +
                ", supplier=" + supplier +
                ", manufactorer=" + manufactorer +
                '}';
    }
}
