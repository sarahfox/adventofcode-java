package com.w3foxes.sarah.Year2023.Day17;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UltraCityGridTest {
    @Test
    public void testFindSimpleShortestPath(){
        List<String> lines = Arrays.asList("111111111111",
                "999999999991",
                "999999999991",
                "999999999991",
                "999999999991");
        UltraCityGrid city = new UltraCityGrid(lines);

        System.out.println(city);
        
        assertEquals(71, city.findShortestPath());
    }

    @Test
    public void testFindLessSimpleShortestPath(){
        // Will not have to divert in this example due to the 4 - 10 block constraint.
        List<String> lines = Arrays.asList("11111", "14441", "14441", "11111");
        UltraCityGrid city = new UltraCityGrid(lines);

        System.out.println(city);
        
        assertEquals(7, city.findShortestPath());
    }

    @Test
    public void testFindShortestPath(){
        List<String> lines = Arrays.asList("2413432311323", 
        "3215453535623", 
        "3255245654254", 
        "3446585845452", 
        "4546657867536", 
        "1438598798454", 
        "4457876987766", 
        "3637877979653", 
        "4654967986887", 
        "4564679986453", 
        "1224686865563", 
        "2546548887735", 
        "4322674655533");
        UltraCityGrid city = new UltraCityGrid(lines);

        assertEquals(94, city.findShortestPath());
    }

}
