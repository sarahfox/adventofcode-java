package com.w3foxes.sarah.Year2024.Day04;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testSimpleSearchForWord() {
        List<String> input = Arrays.asList("XXXX", "XMAS", "XAXX", "XSXX");

        assertEquals(2, Problem1.searchForWord(input, "XMAS"));
    }

    @Test
    public void testSimpleSearchForWord2() {
        List<String> input = Arrays.asList("XXSX", "XXAX", "SAMX", "XXXX");

        assertEquals(2, Problem1.searchForWord(input, "XMAS"));
    }


    @Test
    public void testDiagonalSimpleSearchForWord() {
        List<String> input = Arrays.asList("XXXX", "XMXX", "XXAX", "XXXS");

        assertEquals(1, Problem1.searchForWord(input, "XMAS"));
    }

    @Test
    public void testDiagonalSimpleSearchForWord2() {
        List<String> input = Arrays.asList("SXXX", "XAXX", "XXMX", "XXXX");

        assertEquals(1, Problem1.searchForWord(input, "XMAS"));
    }

    @Test
    public void testDiagonalSimpleSearchForWord3() {
        List<String> input = Arrays.asList("XXXX", "XXMX", "XAXX", "SXXX");

        assertEquals(1, Problem1.searchForWord(input, "XMAS"));
    }

    @Test
    public void testDiagonalSimpleSearchForWord4() {
        List<String> input = Arrays.asList("XXXS", "XXAX", "XMXX", "XXXX");

        assertEquals(1, Problem1.searchForWord(input, "XMAS"));
    }

    @Test
    public void testSearchForWord() {
        List<String> input = Arrays.asList("MMMSXXMASM", "MSAMXMSMSA", "AMXSXMAAMM", "MSAMASMSMX", "XMASAMXAMM", "XXAMMXXAMA", "SMSMSASXSS", "SAXAMASAAA", "MAMMMXMMMM", "MXMXAXMASX");

        assertEquals(18, Problem1.searchForWord(input, "XMAS"));
    }
}
