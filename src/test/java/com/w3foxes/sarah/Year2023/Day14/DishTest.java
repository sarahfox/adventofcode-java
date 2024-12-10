package com.w3foxes.sarah.Year2023.Day14;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DishTest {
    @Test
    public void testMoveNorthAndWeigh() {
        List<String> lines = Arrays.asList("O....#....",
                "O.OO#....#",
                ".....##...",
                "OO.#O....O",
                ".O.....O#.",
                "O.#..O.#.#",
                "..O..#O..O",
                ".......O..",
                "#....###..",
                "#OO..#....");

        Dish d = new Dish(lines);
        // System.out.println(d.toString());
        d.moveRocksNorth();
        // System.out.println(d.toString());

        assertEquals(136, d.calculateWeightOnNorthSide());
    }

    @Test
    public void testSpinCycleAndWeigh() {
        List<String> lines = Arrays.asList("O....#....",
                "O.OO#....#",
                ".....##...",
                "OO.#O....O",
                ".O.....O#.",
                "O.#..O.#.#",
                "..O..#O..O",
                ".......O..",
                "#....###..",
                "#OO..#....");

        Dish d = new Dish(lines);
        System.out.println(d.toString());
        d.spinCycle(1);
        System.out.println(d.toString());

        assertEquals(87, d.calculateWeightOnNorthSide());

        d.spinCycle(1);
        System.out.println(d.toString());

        assertEquals(69, d.calculateWeightOnNorthSide());
        d.spinCycle(1);
        System.out.println(d.toString());

        assertEquals(69, d.calculateWeightOnNorthSide());
    }

    @Test
    public void testLongSpinCycleAndWeigh() {
        List<String> lines = Arrays.asList("O....#....",
                "O.OO#....#",
                ".....##...",
                "OO.#O....O",
                ".O.....O#.",
                "O.#..O.#.#",
                "..O..#O..O",
                ".......O..",
                "#....###..",
                "#OO..#....");

        Dish d = new Dish(lines);
        //System.out.println(d.toString());
        d.spinCycle(1000000000);
        //System.out.println(d.toString());

        assertEquals(64, d.calculateWeightOnNorthSide());
    }
}