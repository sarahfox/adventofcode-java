package com.w3foxes.sarah.Year2024.Day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testProcessLines(){
        List<String> lines = new ArrayList<>();
        lines.add("3   4");
        lines.add("4   3");
        lines.add("2   5");
        lines.add("1   3");
        lines.add("3   9");
        lines.add("3   3");

        long result = Problem2.calculateSimilarity(lines);
        assertEquals(31l, result);
    }
    
}
