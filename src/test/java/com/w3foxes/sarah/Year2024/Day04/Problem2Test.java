package com.w3foxes.sarah.Year2024.Day04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testSearchForXMas() {
        char[][] grid = {{'M', 'X', 'S'}, {'X', 'A', 'X'}, {'M', 'X', 'S'}};

        assertEquals(1, Problem2.searchForXMas(grid));
    }

    @Test
    public void testSearchForXMas2() {
        char[][] grid = {{'X', 'M', 'X'}, {'M', 'A', 'S'}, {'X', 'S', 'S'}};

        assertEquals(1, Problem2.searchForXMas(grid));
    }

    @Test
    public void testSearchForXMas3() {
        char[][] grid = {{'M', 'M', 'M'}, {'M', 'A', 'S'}, {'S', 'S', 'S'}};

        assertEquals(1, Problem2.searchForXMas(grid));
    }

    @Test
    public void testSearchForXMas4() {
        char[][] grid = {{'S', 'S', 'S'}, {'S', 'A', 'M'}, {'M', 'M', 'M'}};

        assertEquals(1, Problem2.searchForXMas(grid));
    }

    @Test
    public void testSearchForXMas5() {
        char[][] grid = {{'S', 'S', 'S'}, {'M', 'A', 'S'}, {'S', 'S', 'S'}};

        assertEquals(0, Problem2.searchForXMas(grid));
    }

    @Test
    public void testSearchForXMasComplex() {
        char[][] grid = {{'.', 'M', '.', 'S', '.', '.', '.', '.', '.', '.'},
            {'.', '.', 'A', '.', '.', 'M', 'S', 'M', 'S', '.'},
            {'.', 'M', '.', 'S', '.', 'M', 'A', 'A', '.', '.'},
            {'.', '.', 'A', '.', 'A', 'S', 'M', 'S', 'M', '.'},
            {'.', 'M', '.', 'S', '.', 'M', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'S', '.', 'S', '.', 'S', '.', 'S', '.', 'S', '.'},
            {'.', 'A', '.', 'A', '.', 'A', '.', 'A', '.', '.'},
            {'M', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};

            assertEquals(9, Problem2.searchForXMas(grid));
    }
}
