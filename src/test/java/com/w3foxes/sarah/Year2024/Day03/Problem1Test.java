package com.w3foxes.sarah.Year2024.Day03;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testFindMulLines() {
        List<String> input = Arrays.asList("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        List<String> result = Problem1.findMulLines(input);

        assertEquals(4, result.size());
        assertEquals("mul(2,4)", result.get(0));
        assertEquals("mul(5,5)", result.get(1));
        assertEquals("mul(11,8)", result.get(2));
        assertEquals("mul(8,5)", result.get(3));
    }

    @Test
    public void testMultiplyValues() {
        List<String> input = Arrays.asList("mul(2,4)", "mul(5,5)", "mul(11,8)", "mul(8,5)");

        assertEquals(161l, Problem1.multiplyValues(input));
    }
}
