package com.w3foxes.sarah.Year2024.Day01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testProcessLines(){
        List<String> lines = new ArrayList<>();
        lines.add("3   4");
        lines.add("4   3");
        lines.add("2   5");
        lines.add("1   3");
        lines.add("3   9");
        lines.add("3   3");

        long result = Problem1.processLines(lines);
        assertEquals(11l, result);
    }
    
}
