package com.w3foxes.sarah.Year2024.Day06;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testGrid() {
        List<String> input = Arrays.asList("....#.....", ".........#", "..........", "..#.......", ".......#..",
                "..........", ".#..^.....", "........#.", "#.........", "......#...");
        Grid g = new Grid(input);
        g.walkGrid();

        assertEquals(41, g.getVisitedPoints().size());
    }

    @Test
    public void testGridWithLoops() {
        List<String> input = Arrays.asList("....#.....", ".........#", "..........", "..#.......", ".......#..",
                "..........", ".#..^.....", "........#.", "#.........", "......#...");
        Grid g = new Grid(input);

        assertEquals(6, g.countPossibleLoops());
    }

    @Test
    public void testSimple() {
        List<String> input = Arrays.asList(".#.", ".^.", "...");
        Grid g = new Grid(input);
        g.walkGrid();

        assertEquals(2, g.getVisitedPoints().size());
    }

    @Test
    public void testSimple2() {
        List<String> input = Arrays.asList(".#..", ".^.#", "....");
        Grid g = new Grid(input);
        g.walkGrid();

        assertEquals(3, g.getVisitedPoints().size());
    }
    @Test
    public void testSimple3() {
        List<String> input = Arrays.asList(".#..", ".^.#", "....", "..#.");
        Grid g = new Grid(input);
        g.walkGrid();

        assertEquals(5, g.getVisitedPoints().size());
    }

    @Test
    public void testSimplePossibleLoops() {
        List<String> input = Arrays.asList(".#..", ".^.#", "....", "..#.");
        Grid g = new Grid(input);
       
        assertEquals(1, g.countPossibleLoops());
    }
}
