package com.w3foxes.sarah.Year2024.Day14;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.w3foxes.sarah.util.Point;

public class Problem1Test {
    @Test
    public void testSingularRobot() {
        String input = "p=2,4 v=2,-3";
        Robot r = new Robot(input);

        Point p1 = r.run(7, 11, 1);
        assertEquals(new Point(1, 4), p1);
        
        Point p2 = r.run(7, 11, 2);
        assertEquals(new Point(5,6), p2);

        Point p3 = r.run(7, 11, 3);
        assertEquals(new Point(2,8), p3);

        Point p4 = r.run(7, 11, 4);
        assertEquals(new Point(6,10), p4);

        Point p5 = r.run(7, 11, 5);
        assertEquals(new Point(3,1), p5);

    }

    @Test
    public void testBiggerExample() {
        List<String> lines = Arrays.asList("p=0,4 v=3,-3", 
            "p=6,3 v=-1,-3", 
            "p=10,3 v=-1,2", 
            "p=2,0 v=2,-1", 
            "p=0,0 v=1,3", 
            "p=3,0 v=-2,-2", 
            "p=7,6 v=-1,-3", 
            "p=3,0 v=-1,-2", 
            "p=9,3 v=2,3", 
            "p=7,3 v=-1,2", 
            "p=2,4 v=2,-3", 
            "p=9,5 v=-3,-3");
        Map<Quadrant, Long> result = Problem1.runRobots(lines, 7, 11, 100);
        assertEquals(Long.valueOf(1l), result.get(Quadrant.UPPER_LEFT));
        assertEquals(Long.valueOf(3l), result.get(Quadrant.UPPER_RIGHT));
        assertEquals(Long.valueOf(4l), result.get(Quadrant.LOWER_LEFT));
        assertEquals(Long.valueOf(1l), result.get(Quadrant.LOWER_RIGHT));

    }
}
