package com.w3foxes.sarah.Year2023.Day01;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class Problem1Test 
{
    /**
     * Rigorous Test :-)
     */
    @ParameterizedTest
    @CsvSource({"onethreecqnczs8tdfiveeightthree,1", 
        "1rxfour4xjzdfgqsixmjvvzfnh6m,1", 
        "three98oneightzn,3"})
    public void testFindFirstDigit(String input, String expected)
    {
        assertEquals(expected, "" + Problem2.findFirstDigit(expected));
    }

    @ParameterizedTest
    @CsvSource({"onethreecqnczs8tdfiveeightthree,3", 
        "1rxfour4xjzdfgqsixmjvvzfnh6m,6", 
        "three98oneightzn,8"})
    public void testFindLastDigit(String input, String expected)
    {
        assertEquals(expected, "" + Problem2.findLastDigit(expected));
    }
}
