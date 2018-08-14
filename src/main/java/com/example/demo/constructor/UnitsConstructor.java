package com.example.demo.constructor;

import com.example.demo.SpreadSheets.SpreadSheets;
import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitsConstructor {

    MixUnit.type type;

    public UnitsConstructor(MixUnit mixUnit) {
        Class type = mixUnit.getClass();
        Map<SpecElement, Integer> elements = null;
        if (type.equals(MixUnitTS.class)){
            elements = createListOfElements(mixUnit, new UnitModel(MixUnit.type.TS));
        }
        if (type.equals(MixUnitHS.class)){
            elements = createListOfElements(mixUnit, new UnitModel(MixUnit.type.HS));
        }
        specificationOutput(elements, mixUnit);
    }

    private Map<SpecElement,Integer> createListOfElements(MixUnit unit, UnitModel model){

        double mainDn = unit.getDn();
        Map<String, Integer> specMap = model.getSpecMap();
        Map<SpecElement, Integer> specElements = new HashMap<>();

        for (Map.Entry<String, Integer> entry : specMap.entrySet()) {
            if (entry.getValue() != 0.){
                SpecElement element = new SpecElement();
                element.name = entry.getKey();
                element.dnMain = mainDn;
                specElements.put(element, entry.getValue());
            }
        }
        return specElements;
    }
    private void specificationOutput(Map<SpecElement, Integer> specElements, MixUnit mixUnit){

        SpreadSheets.specSheetInsert(specElements, mixUnit.getFullName());

    }
}
