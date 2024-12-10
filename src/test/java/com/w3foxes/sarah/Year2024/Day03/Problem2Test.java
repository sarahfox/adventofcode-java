package com.w3foxes.sarah.Year2024.Day03;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testFindMulLines() {
       String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        List<String> result = Problem2.findEnabledMulLines(input);

        assertEquals(2, result.size());
        assertEquals("mul(2,4)", result.get(0));
        assertEquals("mul(8,5)", result.get(1));
    }

    @Test
    public void testMultiplyValues() {
        List<String> input = Arrays.asList("mul(2,4)", "mul(5,5)", "mul(11,8)", "mul(8,5)");

        assertEquals(161l, Problem2.multiplyValues(input));
    }
}
