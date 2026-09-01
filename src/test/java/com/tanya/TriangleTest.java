package com.tanya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    void testArea() {
        assertEquals(25.0, Triangle.area(10, 5));
    }
}
