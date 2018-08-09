package com.example.demo.Selection;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @Test
    void getPresLose() {
        System.out.println(Calculations.getPresLose(11, 10));
    }

    @Test
    void isPumpFits() {
        assertTrue(Calculations.isPumpFits(2, 2, "y = -0.0218x2 - 0.0928x + 10.872"));
        assertTrue(!Calculations.isPumpFits(200, 200, "y = -0.0218x2 - 0.0928x + 10.872"));
        assertTrue(Calculations.isPumpFits(2, 2.5, "y = -0.2736x2 - 0.7232x + 5.8378"));
        assertTrue(!Calculations.isPumpFits(2, 3.5, "y = -0.2736x2 - 0.7232x + 5.8378"));
        assertTrue(Calculations.isPumpFits(2, 2.75, "y = -0.2736x2 - 0.7232x + 5.8378"));
    }
}