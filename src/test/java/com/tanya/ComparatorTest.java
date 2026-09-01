package com.tanya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {

    @Test
    void testCompare() {
        assertEquals(1, Comparator.compare(5, 3));
    }
}
