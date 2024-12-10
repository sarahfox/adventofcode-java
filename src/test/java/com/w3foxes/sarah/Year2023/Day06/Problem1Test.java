package com.w3foxes.sarah.Year2023.Day06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testCalculateWaysToBeat() {
        assertEquals(4, Problem1.calculateWaysToBeat(7, 9));
        assertEquals(8, Problem1.calculateWaysToBeat(15, 40));
        assertEquals(9, Problem1.calculateWaysToBeat(30, 200));
    }
}
