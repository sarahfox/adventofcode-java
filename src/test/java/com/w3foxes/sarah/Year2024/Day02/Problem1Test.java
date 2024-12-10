package com.w3foxes.sarah.Year2024.Day02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testIsSafe1(){
        assertTrue(Problem1.isSafe("7 6 4 2 1"));
    }
    
    @Test
    public void testIsSafe2(){
        assertFalse(Problem1.isSafe("1 2 7 8 9"));
    }
    
    @Test
    public void testIsSafe3(){
        assertFalse(Problem1.isSafe("9 7 6 2 1"));
    }
    
    @Test
    public void testIsSafe4(){
        assertFalse(Problem1.isSafe("1 3 2 4 5"));
    }
    
    @Test
    public void testIsSafe5(){
        assertFalse(Problem1.isSafe("8 6 4 4 1"));
    }
    
    @Test
    public void testIsSafe6(){
        assertTrue(Problem1.isSafe("1 3 6 7 9"));
    }
    
}
