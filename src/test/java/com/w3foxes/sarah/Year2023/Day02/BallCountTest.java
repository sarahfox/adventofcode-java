package com.w3foxes.sarah.Year2023.Day02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallCountTest {
    
    @Test
    public void testCreateBallCount(){
        String nineGreen = " 9 green ";
        String fiveBlue = "5 blue";
        String twentyRed = "20  red";

        BallCount green = new BallCount(nineGreen);
        assertTrue(green.getColor() == BallColor.green);
        assertEquals(9, green.getCount());
        
        BallCount blue = new BallCount(fiveBlue);
        assertTrue(blue.getColor() == BallColor.blue);
        assertEquals(5, blue.getCount());
  
        BallCount red = new BallCount(twentyRed);
        assertTrue(red.getColor() == BallColor.red);
        assertEquals(20, red.getCount());    
    }

    @ParameterizedTest
    @ValueSource(strings = {"9 green", "5 blue", "6 red"})
    public void testIsPossible_trueCase(String input) {
        BallCount ballCount = new BallCount(input);
        assertTrue(ballCount.isPossible());
    }

    @ParameterizedTest
    @ValueSource(strings = {"19 green", "25 blue", "36 red"})
    public void testIsPossible_falseCase(String input) {
        BallCount ballCount = new BallCount(input);
        assertFalse(ballCount.isPossible());
    }

}
