package com.example.demo;

import com.example.demo.Selection.UnitSelect;
import com.example.demo.commercial.OfferedEquipment.MixUnit;
import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import com.example.demo.commercial.OfferedEquipment.MixUnitTS;
import com.example.demo.commercial.PurchasingEquipment.Fittings.IMP_Pump;
import com.example.demo.dao.Dao;
import com.example.demo.models.Hibernatable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.commercial.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Test
	public void main() {

		UnitSelect unitSelect = new UnitSelect(MixUnit.type.TS);
		System.out.println(unitSelect.getFitsUnit(15.,5.));


//		List<Object> all = new ArrayList<>();//OK
//		all.addAll(Dao.findAll(MixUnitTS.class));
//		all.addAll(Dao.findAll(MixUnitHS.class));
//		for (Object o : all) {
//			System.out.println(((MixUnit)o).getBasic_name());
//		}
	}
}
