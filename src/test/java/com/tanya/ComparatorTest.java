package com.tanya;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;;

public class ComparatorTest {

    @Test
    void testCompare() {
        assertEquals(1, Comparator.compare(5, 3));
    }
}
