package com.example.demo.Selection;

import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;
import com.example.demo.constructor.UnitsConstructor;
import com.example.demo.dao.Dao;
import com.example.demo.models.Hibernatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitSelect {

    List<?> unitsToCooseFrom;

    MixUnit.type typeOfUnit;

    public static String getSelectedModel(Map<String,String> params){

        double flow = Double.parseDouble(params.get("flow"));
        double presLose = Double.parseDouble(params.get("presLose"));
        int kipQty = Integer.parseInt(params.get("kipQty"));
        int flexQty = Integer.parseInt(params.get("flexQty"));
        int valvesQty = Integer.parseInt(params.get("valvesQty"));
        boolean isPresentRelay = Boolean.parseBoolean(params.get("isPresentRelay"));
        MixUnit.type unitType = null;
        String type = params.get("type");
        if (type.equals("ts"))unitType = MixUnit.type.TS;
        if (type.equals("hs"))unitType = MixUnit.type.HS;
        UnitSelect unitSelect = new UnitSelect(unitType);

        MixUnit selectedUnit = unitSelect.getFitsUnit(flow,presLose);//main stuff

        //pass the unit to form a specification;
        new Thread(()-> {UnitsConstructor unitsConstructor = new UnitsConstructor(selectedUnit);}).start();

        StringBuilder unitFullModel = new StringBuilder(selectedUnit.getBasic_name());
        if (kipQty>0)unitFullModel.append("-" + kipQty + "КИП");
        if (flexQty>0)unitFullModel.append("-" + flexQty + "ГП");
        if (valvesQty>0)unitFullModel.append("-" + valvesQty + "БВ");
        if (isPresentRelay)unitFullModel.append("-РД");
        return unitFullModel.toString();
    }


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
    public MixUnit getFitsUnit(Double flow, Double presLose){
        // flow in m3/h and preslose in meters.
        if (typeOfUnit == MixUnit.type.TS) return getFitsTSUnit(flow,presLose);
        if (typeOfUnit == MixUnit.type.HS) return getFitsHSUnit(flow,presLose);
        return null;
    }

    private MixUnit getFitsHSUnit(Double flow, Double presLose){
        MixUnitHS selected;
        for (Object o : unitsToCooseFrom) {
            selected = (MixUnitHS)o;
            if (selected.isFits(flow, presLose)){
                return selected;
            }
        }
        return null;

    }private MixUnit getFitsTSUnit(Double flow, Double presLose){
        MixUnitTS selected;
        for (Object o : unitsToCooseFrom) {
            selected = (MixUnitTS)o;
            if (selected.isFits(flow, presLose)){
                return selected;
            }
        }
        return null;
    }
}
