package com.tanya;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    void testFactorial() {
        assertEquals(120, Factorial.calculate(5));
    }
}
