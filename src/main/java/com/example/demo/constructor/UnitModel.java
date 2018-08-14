package com.example.demo.constructor;

import com.example.demo.commercial.OfferedEquipment.MixUnit;

import java.util.HashMap;
import java.util.Map;

public class UnitModel {

    static Map<String, Integer> specMap = new HashMap<>();

    // TODO: 14.08.2018 this is testing arrays will be replased by information from base ,or custom selection
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
        specMap.put("teeQty", arr[0]);
        specMap.put("shutterValveQty", arr[1]);
        specMap.put("filterQty", arr[2]);
        specMap.put("returnValveQty", arr[3]);
        specMap.put("AmericanConnectionQty", arr[4]);
        specMap.put("nippleQty", arr[5]);
        specMap.put("threadedPipeQty", arr[6]);

    }

    public Map<String, Integer> getSpecMap() {
        return specMap;
    }
}

