package com.example.demo.commercial;

import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    class Ass{

        @Override
        public int hashCode() {
            return aa.hashCode();
        }

        String aa = "a";
    }

    @Test
    void check() {

        Price price = new Price(new MixUnitHS(), Currency.RUB, false, 0.090);
        assertTrue(price.kindOfPrice == Tradable.kind.SELL);

        Ass ass = new Ass();
        Ass bss = new Ass();
        System.out.println("bss = " + bss);
        System.out.println("ass = " + ass);
        System.out.println("bss = " + bss.hashCode());
        System.out.println("ass = " + ass.hashCode());

        String anna = new String("anna");
        String anna1 = new String("anna");

        System.out.println(anna == anna1);

    }
}