package com.w3foxes.sarah.Year2024.Day07;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testCanBeSolved(){
        List<String> lines = Arrays.asList("190: 10 19", 
            "3267: 81 40 27", 
            "83: 17 5", 
            "156: 15 6", 
            "7290: 6 8 6 15", 
            "161011: 16 10 13", 
            "192: 17 8 14", 
            "21037: 9 7 18 13", 
            "292: 11 6 16 20");
            
        assertEquals(190, Problem2.canBeSolved(lines.get(0)));
        assertEquals(3267, Problem2.canBeSolved(lines.get(1)));
        assertEquals(0, Problem2.canBeSolved(lines.get(2)));
        assertEquals(156, Problem2.canBeSolved(lines.get(3)));
        assertEquals(7290, Problem2.canBeSolved(lines.get(4)));
        assertEquals(0, Problem2.canBeSolved(lines.get(5)));
        assertEquals(192, Problem2.canBeSolved(lines.get(6)));
        assertEquals(0, Problem2.canBeSolved(lines.get(7)));
        assertEquals(292, Problem2.canBeSolved(lines.get(8)));
    }
}
