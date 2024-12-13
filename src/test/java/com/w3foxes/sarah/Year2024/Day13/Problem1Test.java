package com.w3foxes.sarah.Year2024.Day13;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testFindFewestTokens1(){
        List<String> lines = Arrays.asList("Button A: X+94, Y+34", "Button B: X+22, Y+67", "Prize: X=8400, Y=5400");
        
        assertEquals(280, Problem1.findFewestTokens(lines));
    }

    @Test
    public void testFindFewestTokens2() {
        List<String> lines = Arrays.asList("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=12748, Y=12176");

        assertEquals(0, Problem1.findFewestTokens(lines));
    }

    @Test
    public void testFindFewestTokens3() {
        List<String> lines = Arrays.asList("Button A: X+17, Y+86", "Button B: X+84, Y+37", "Prize: X=7870, Y=6450");

        assertEquals(200, Problem1.findFewestTokens(lines));
    }

    @Test
    public void testFindFewestTokens4() {
        List<String> lines = Arrays.asList("Button A: X+69, Y+23", "Button B: X+27, Y+71", "Prize: X=18641, Y=10279");

        assertEquals(0, Problem1.findFewestTokens(lines));
    }
}
