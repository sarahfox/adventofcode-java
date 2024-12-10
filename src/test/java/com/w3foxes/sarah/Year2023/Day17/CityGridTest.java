package com.w3foxes.sarah.Year2023.Day17;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CityGridTest {
    @Test
    public void testFindSimpleShortestPath(){
        List<String> lines = Arrays.asList("24", "32", "52");
        CityGrid city = new CityGrid(lines);

        System.out.println(city);
        
        assertEquals(7, city.findShortestPath());
    }

    @Test
    public void testFindLessSimpleShortestPath(){
        // Will have to divert in this example due to the 3 block constraint.
        List<String> lines = Arrays.asList("11111", "14441", "14441", "11111");
        CityGrid city = new CityGrid(lines);

        System.out.println(city);
        
        assertEquals(10, city.findShortestPath());
    }

    @Test
    public void testFindAnotherShortestPath() {
        List<String> lines = Arrays.asList("14999", "23111", "99991");
        CityGrid city = new CityGrid(lines);

        assertEquals(11, city.findShortestPath());
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
        //[0, 0, 1, 0, 2, 0, 2, 1, 3, 1, 4, 1, 4, 0, 5, 0, 6, 0, 6, 1, 7, 1, 8, 1, 8, 2, 9, 2, 9, 3, 10, 3, 10, 4, 10, 5, 11, 5, 11, 6, 11, 7, 12, 7, 12, 8, 12, 9, 11, 9, 11, 10, 12, 10, 12, 11, 12, 12]
        CityGrid city = new CityGrid(lines);

        assertEquals(102, city.findShortestPath());
    }
}
