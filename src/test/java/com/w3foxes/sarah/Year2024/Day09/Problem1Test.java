package com.w3foxes.sarah.Year2024.Day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testCompactAndFindChecksum() {
        String input = "2333133121414131402";

        assertEquals(1928, Problem1.compactAndFindChecksum(input));
    }

    @Test
    public void testParseBlocks() {
        String input = "12345";
        assertEquals(60, Problem1.compactAndFindChecksum(input));
    }
}
