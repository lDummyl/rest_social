package com.example.demo.Configs;

import com.example.demo.commercial.PurchasingEquipment.Pumps.IMP_Pump;

import java.util.ArrayList;

public class HiberConfig {
    // Placing Entities for Hibernate for SessionUtilFactory
    public static ArrayList<Class> entitiesClassesList;

    static{
        entitiesClassesList = new ArrayList<>();
        entitiesClassesList.add(IMP_Pump.class);
    }

}
