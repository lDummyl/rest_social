package com.example.demo.constructor;

import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.commercial.PurchasingEquipment.Fitting;

import java.util.HashMap;
import java.util.Map;

public class UnitModel {
//    Model contains qty of main elements, required to build a unit
//    it is constant to different unit types, and might be expanded
//    in custom selection mode.


//    static Map<String, Integer> specMap = new HashMap<>(); //represents fitting essence and required qty.
    static Map<String, Integer> specMap = new HashMap<>(); //represents fitting essence and required qty.

    // TODO: 14.08.2018 this is testing arrays which will be replaced by information from base, or custom selection.
    final int[] tsMap = new int[]{3, 2, 1, 1, 1, 1, 2};
    final int[] hsMap = new int[]{1, 2, 1, 0, 0, 1, 1};

    public UnitModel(MixUnit.type type) {
        if (type == MixUnit.type.TS) {
            fillMainElements(tsMap);
        }
        if (type == MixUnit.type.HS) {
            fillMainElements(hsMap);
        }
    }

    private void fillMainElements(int[] arr) {

        Fitting.essences[] essences = Fitting.essences.values();
        for (int i = 0; i < essences.length; i++) {
            specMap.put(essences[i].name(), arr[i]);
        }
    }

    public Map<String, Integer> getSpecMap() {
        return specMap;
    }
}

