package com.tanya;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;;

public class CalculatorTest {

    @Test
    void testAdd() {
        assertEquals(8, Calculator.add(5, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, Calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, Calculator.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, Calculator.divide(6, 3));
    }
}


