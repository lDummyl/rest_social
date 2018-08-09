package com.example.demo.Configs;


import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;
import com.example.demo.commercial.PurchasingEquipment.Fittings.IMP_Pump;

import java.util.ArrayList;

public class HiberConfig {

    // Placing Entities for Hibernate for SessionUtilFactory

    public static ArrayList<Class> entitiesClassesList = new ArrayList<>();

    public static ArrayList<Class> getEntitiesClassesList() {

        entitiesClassesList.add(MixUnitTS.class);
        entitiesClassesList.add(MixUnitHS.class);
        entitiesClassesList.add(IMP_Pump.class);

        return entitiesClassesList;
    }

}


