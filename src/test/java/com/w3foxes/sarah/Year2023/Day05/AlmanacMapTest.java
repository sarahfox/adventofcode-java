package com.w3foxes.sarah.Year2023.Day05;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AlmanacMapTest {
    @Test
    public void testCreateAlmanacMap() {
        AlmanacMap am = new AlmanacMap("seed-to-soil map:");

        assertEquals("seed", am.getFrom());
        assertEquals("soil", am.getTo());
        
        am.addRange("50 98 2");

        List<Range> ranges = am.getRanges();
        assertEquals(1, ranges.size());
        assertEquals(98, ranges.get(0).getFromStart());
        assertEquals(50, ranges.get(0).getToStart());
        assertEquals(2, ranges.get(0).getRangeLength());
    }

    @Test
    public void testConvertPoint() {
       AlmanacMap am = new AlmanacMap("seed-to-soil map:");
        am.addRange("50 98 2");

        assertEquals(50, am.convertPoint(98));
        assertEquals(51, am.convertPoint(99));
        assertEquals(100, am.convertPoint(100));
    }
}
