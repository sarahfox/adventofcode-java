package com.w3foxes.sarah.Year2024.Day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testCalculateFencingCost1() {
        char[][] input = {{'A','A','A','A'},
            {'B','B','C','D'},
            {'B','B','C','C'},
            {'E','E','E','C'}};

        assertEquals(80, Problem2.calculateFencingCosts(input));
    }

    @Test
    public void testCalculateFencingCost2() {
        char[][] input = {{'O','O','O','O','O'},
            {'O','X','O','X','O'},
            {'O','O','O','O','O'},
            {'O','X','O','X','O'},
            {'O','O','O','O','O'}};

        assertEquals(436, Problem2.calculateFencingCosts(input));
    }

    @Test
    public void testCalculateFencingCost3(){
        char[][] input = {{'R','R','R','R','I','I','C','C','F','F'},
            {'R','R','R','R','I','I','C','C','C','F'},
            {'V','V','R','R','R','C','C','F','F','F'},
            {'V','V','R','C','C','C','J','F','F','F'},
            {'V','V','V','V','C','J','J','C','F','E'},
            {'V','V','I','V','C','C','J','J','E','E'},
            {'V','V','I','I','I','C','J','J','E','E'},
            {'M','I','I','I','I','I','J','J','E','E'},
            {'M','I','I','I','S','I','J','E','E','E'},
            {'M','M','M','I','S','S','J','E','E','E'}};

        assertEquals(1206, Problem2.calculateFencingCosts(input));
    }
}
