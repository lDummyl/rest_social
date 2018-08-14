package com.example.demo.Selection;

import com.example.demo.commercial.OfferedEquipment.MixUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitSelectTest {

   @Test
   public void test(){

       String[] results = new String[]{"СУ3-ХС-16", "СУ3-ХС-2.5", "СУ3-ХС-2.5", "not selected", "СУ3-ХС-40"};
       Double[][] inputs = new Double[][]{{10.,2.}, {1.,2.}, {0.,0.}, {101.,2.}, {20.,6.}};
       Double[][] inputsTS = new Double[][]{{10.,2.}, {1.,2.}, {0.,0.}, {101.,2.}, {15.,20.}};

       for (int i = 0; i<results.length; i++) {
           String unit = new UnitSelect(MixUnit.type.HS).getFitsUnit(inputs[i][0],inputs[i][1]).getBasic_name();
           System.out.println(unit);
           assertTrue(unit.equals(results[i]));
       }

       for (int i = 0; i < inputsTS.length; i++) {
           String unit = new UnitSelect(MixUnit.type.TS).getFitsUnit(inputsTS[i][0], inputsTS[i][1]).getBasic_name();
           System.out.println(unit);
       }
    }
}