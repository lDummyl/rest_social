package com.example.demo;

import com.example.demo.commercial.PurchasingEquipment.Pumps.IMP_Pump;
import com.example.demo.dao.Dao;
import com.example.demo.models.Hibernatable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void main() {
		String[] args = new String[0];
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Start!");
		System.out.println(new Dao().findAll(Visitor.class));
		System.out.println(new Dao().findAll(IMP_Pump.class));
		new Dao().save(new Visitor("Vova"));
		new Dao().save(new IMP_Pump());
		assertTrue(new VisitorDao().findById(20).getName().equals("Dima"));
		List<Hibernatable> visitorsList = Dao.findAll(Visitor.class);
		boolean vovaPresent=false;
		for (Hibernatable h : visitorsList) {
			Visitor v = (Visitor)h;
			vovaPresent = (v.getName().equals("Vova"))? true : vovaPresent;
		}
		assertTrue(vovaPresent);
	}
}
