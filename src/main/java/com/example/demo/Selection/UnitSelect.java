package com.example.demo.Selection;

import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;
import com.example.demo.dao.Dao;
import com.example.demo.models.Hibernatable;

import java.util.ArrayList;
import java.util.List;

public class UnitSelect {

    List<?> unitsToCooseFrom =new ArrayList<>();

    MixUnit.type typeOfUnit;

    public UnitSelect(MixUnit.type typeOfUnit) {
        this.typeOfUnit = typeOfUnit;
        Class<? extends Hibernatable> cl = null;
        if (typeOfUnit == MixUnit.type.HS){
            cl =MixUnitHS.class;
        }
        if (typeOfUnit == MixUnit.type.TS){
            cl =MixUnitTS.class;
        }
        unitsToCooseFrom = Dao.findAll(cl);
    }
    public String getFitsUnit(Double flow, Double presLose){
        // flow in m3/h and preslose in meters.
        if (typeOfUnit == MixUnit.type.TS) return getFitsTSUnit(flow,presLose);
        if (typeOfUnit == MixUnit.type.HS) return getFitsHSUnit(flow,presLose);
        return "Not selected";
    }

    private String getFitsHSUnit(Double flow, Double presLose){
        MixUnitHS selected;
        for (Object o : unitsToCooseFrom) {
            selected = (MixUnitHS)o;
            if (selected.isFits(flow, presLose)){
                return selected.getBasic_name();
            }
        }
        return "not selected";

    }private String getFitsTSUnit(Double flow, Double presLose){
        MixUnitTS selected;
        selected = (MixUnitTS)unitsToCooseFrom.get(1);
        String basic_name = selected.getBasic_name();
        return basic_name;
    }
}
