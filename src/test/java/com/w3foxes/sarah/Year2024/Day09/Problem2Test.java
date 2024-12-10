package com.w3foxes.sarah.Year2024.Day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testCompactAndFindChecksum() {
        String input = "2333133121414131402";

        assertEquals(2858, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testSimpleCompactAndFindChecksum() {
        String input = "12345";
        assertEquals(132, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testSimpleerCompactAndFindChecksum() {
        String input = "153";
        assertEquals(6, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testCompactAndFindChecksumEdgeCase() {
        String input = "14113";
        assertEquals(16, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testCompactAndFindChecksumEdgeCase2() {
        String input = "1010101010101010101010";
        assertEquals(385, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testCompactAndFindChecksumEdgeCase3() {
        String input = "354631466260";
        assertEquals(1325, Problem2.compactAndFindChecksum(input));
    }

    @Test
    public void testCompactAndFindChecksumEdgeCase4() {
        String input = "2333133121414131401";
        assertEquals(2746, Problem2.compactAndFindChecksum(input));
        //009441117772...333....5555.6666.....8888
        //009441117772333.......5555.6666.....8888
    }
}
