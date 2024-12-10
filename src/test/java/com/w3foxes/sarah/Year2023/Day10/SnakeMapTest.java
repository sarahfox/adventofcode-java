package com.w3foxes.sarah.Year2023.Day10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SnakeMapTest {
    @Test
    public void testSnakeMap(){
        SnakeMap snakeMap = new SnakeMap();
        snakeMap.readLine(".....");
        snakeMap.readLine(".S-7.");
        snakeMap.readLine(".|.|.");
        snakeMap.readLine(".L-J.");
        snakeMap.readLine(".....");

        assertEquals(4, snakeMap.walkToFarthestPoint());
        assertEquals(1, snakeMap.countLoopInsides());
    }

    @Test
    public void testMoreComplexSnakeMap(){
        SnakeMap snakeMap = new SnakeMap();
        snakeMap.readLine("...........");
        snakeMap.readLine(".S-------7.");
        snakeMap.readLine(".|F-----7|.");
        snakeMap.readLine(".||.....||.");
        snakeMap.readLine(".||.....||.");
        snakeMap.readLine(".|L-7.F-J|.");
        snakeMap.readLine(".|..|.|..|.");
        snakeMap.readLine(".L--J.L--J.");
        snakeMap.readLine("...........");
        snakeMap.walkToFarthestPoint();
        assertEquals(4, snakeMap.countLoopInsides());
    }

    @Test
    public void testEvenMoreComplexSnakeMap(){
        SnakeMap snakeMap = new SnakeMap();
        snakeMap.readLine(".F----7F7F7F7F-7....");
        snakeMap.readLine(".|F--7||||||||FJ....");
        snakeMap.readLine(".||.FJ||||||||L7....");
        snakeMap.readLine("FJL7L7LJLJ||LJ.L-7..");
        snakeMap.readLine("L--J.L7...LJS7F-7L7.");
        snakeMap.readLine("....F-J..F7FJ|L7L7L7");
        snakeMap.readLine("....L7.F7||L7|.L7L7|");
        snakeMap.readLine(".....|FJLJ|FJ|F7|.LJ");
        snakeMap.readLine("....FJL-7.||.||||...");
        snakeMap.readLine("....L---J.LJ.LJLJ...");

        snakeMap.walkToFarthestPoint();
        assertEquals(8, snakeMap.countLoopInsides());
    }

    @Test
    public void testVeryComplexSnakeMap(){
        SnakeMap snakeMap = new SnakeMap();

        snakeMap.readLine("FF7FSF7F7F7F7F7F---7");
        snakeMap.readLine("L|LJ||||||||||||F--J");
        snakeMap.readLine("FL-7LJLJ||||||LJL-77");
        snakeMap.readLine("F--JF--7||LJLJ7F7FJ-");
        snakeMap.readLine("L---JF-JLJ.||-FJLJJ7");
        snakeMap.readLine("|F|F-JF---7F7-L7L|7|");
        snakeMap.readLine("|FFJF7L7F-JF7|JL---7");
        snakeMap.readLine("7-L-JL7||F7|L7F-7F7|");
        snakeMap.readLine("L.L7LFJ|||||FJL7||LJ");
        snakeMap.readLine("L7JLJL-JLJLJL--JLJ.L");

        snakeMap.walkToFarthestPoint();
        assertEquals(10, snakeMap.countLoopInsides());
    }
}
