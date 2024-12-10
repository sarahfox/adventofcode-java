package com.w3foxes.sarah.Year2023.Day13;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReflectionMapTest {
    @Test
    public void testFindReflection_vertical() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#.##..##.");
        map.readLine("..#.##.#.");
        map.readLine("##......#");
        map.readLine("##......#");
        map.readLine("..#.##.#.");
        map.readLine("..##..##.");
        map.readLine("#.#.##.#.");

        assertEquals(5, map.findReflection());
    }

    @Test
    public void testFindReflection_horizontal() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#...##..#");
        map.readLine("#....#..#");
        map.readLine("..##..###");
        map.readLine("#####.##.");
        map.readLine("#####.##.");
        map.readLine("..##..###");
        map.readLine("#....#..#");

        assertEquals(400, map.findReflection());
    }

    @Test
    public void testFindReflection_double() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#....#");
        map.readLine(".#..#.");
        map.readLine(".#..#.");
        map.readLine("#....#");

        assertEquals(203, map.findReflection());
    }

    @Test
    public void testFindRealReflection() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#####....####");
        map.readLine(".####....####");
        map.readLine("...#.#..#.#..");
        map.readLine(".##..####..##");
        map.readLine("..#.##..##.#.");
        map.readLine("#####.##.####");
        map.readLine(".###......###");

        assertEquals(7, map.findReflection());
    }

    @Test
    public void testFindSmudgedReflection1() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#.##..##.");
        map.readLine("..#.##.#.");
        map.readLine("##......#");
        map.readLine("##......#");
        map.readLine("..#.##.#.");
        map.readLine("..##..##.");
        map.readLine("#.#.##.#.");

        assertEquals(300, map.findSmudgedReflection());
       
    }

    @Test
    public void testFindSmudgedReflection2() {
        ReflectionMap map = new ReflectionMap();
        map.readLine("#...##..#");
        map.readLine("#....#..#");
        map.readLine("..##..###");
        map.readLine("#####.##.");
        map.readLine("#####.##.");
        map.readLine("..##..###");
        map.readLine("#....#..#");

        assertEquals(100, map.findSmudgedReflection());
    }


}
