package com.w3foxes.sarah.Year2024.Day10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testExample1() {
        int[][] input = {{0,1,2,3},
            {1,2,3,4},
            {8,7,6,5},
            {9,8,7,6}};

        assertEquals(16, Problem2.scoreGrid(input));
    }
    @Test
    public void testExample2() {
        int[][] input = {{9,9,9,0,9,9,9},
            {9,9,9,1,9,9,9},
            {9,9,9,2,9,9,9},
            {6,5,4,3,4,5,6},
            {7,9,9,9,9,9,7},
            {8,8,8,8,8,8,8},
            {9,9,9,9,9,9,9}};

        assertEquals(2, Problem2.scoreGrid(input));
    }
    @Test
    public void testExample5() {
        int[][] input = {{8,9,0,1,0,1,2,3},
            {7,8,1,2,1,8,7,4},
            {8,7,4,3,0,9,6,5},
            {9,6,5,4,9,8,7,4},
            {4,5,6,7,8,9,0,3},
            {3,2,0,1,9,0,1,2},
            {0,1,3,2,9,8,0,1},
            {1,0,4,5,6,7,3,2}};

        assertEquals(81, Problem2.scoreGrid(input));
    }
}
