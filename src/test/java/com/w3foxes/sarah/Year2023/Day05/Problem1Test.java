package com.w3foxes.sarah.Year2023.Day05;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testReadSeedList() {
        String line = "seeds: 79 14 55 13";
        List<Long> result = Problem1.readSeedList(line);

        assertEquals(4, result.size());
        assertTrue(result.contains(Long.valueOf(79)));
        assertTrue(result.contains(Long.valueOf(14)));
        assertTrue(result.contains(Long.valueOf(55)));
        assertTrue(result.contains(Long.valueOf(13)));
    }

    @Test
    public void testRegex() {
        String line = "seeds: 79 14 55 13";
        String line2 = "seed-to-soil map:";

        assertTrue(line.contains("seeds:"));
        assertTrue(line2.contains("-to-"));
    }
}
