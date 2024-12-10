package com.w3foxes.sarah.Year2023.Day06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testCalculateWaysToBeat() {
        assertEquals(Long.valueOf(4), Problem2.calculateWaysToBeat(7, 9));
        assertEquals(Long.valueOf(8), Problem2.calculateWaysToBeat(15, 40));
        assertEquals(Long.valueOf(9), Problem2.calculateWaysToBeat(30, 200));
    }
}
