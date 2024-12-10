package com.w3foxes.sarah.Year2023.Day09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SequenceTest {
    @Test
    public void testCreateSequence(){
        Sequence s1 = new Sequence("0   3   6   9  12  15");
        assertEquals((long) 18, s1.getPrediction());
        assertEquals((long) -3, s1.getPrevious());

        Sequence s2 = new Sequence("1   3   6  10  15  21");
        assertEquals((long) 28, s2.getPrediction());
        assertEquals((long) 0, s2.getPrevious());

        Sequence s3 = new Sequence("10  13  16  21  30  45");
        assertEquals((long) 68, s3.getPrediction());
        assertEquals((long) 5, s3.getPrevious());
    }
}
