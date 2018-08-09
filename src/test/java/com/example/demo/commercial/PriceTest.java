package com.example.demo.commercial;

import com.example.demo.commercial.OfferedEquipment.MixUnitHS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void check() {

        Price price = new Price(new MixUnitHS(), Currency.RUB, false, 0.090);
        assertTrue(price.kindOfPrice == Tradable.kind.SELL);

    }
}