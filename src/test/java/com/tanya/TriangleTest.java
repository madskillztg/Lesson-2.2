package com.tanya;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTest {

    @Test
    void testArea() {
        assertEquals(25.0, Triangle.area(10, 5));
    }
}
