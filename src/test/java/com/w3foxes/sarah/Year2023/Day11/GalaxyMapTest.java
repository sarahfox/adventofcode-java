package com.w3foxes.sarah.Year2023.Day11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GalaxyMapTest {
    @Test
    public void testGalaxyMap() {
        GalaxyMap g1 = new GalaxyMap();
        g1.readLine("...#......");
        g1.readLine(".......#..");
        g1.readLine("#.........");
        g1.readLine("..........");
        g1.readLine("......#...");
        g1.readLine(".#........");
        g1.readLine(".........#");
        g1.readLine("..........");
        g1.readLine(".......#..");
        g1.readLine("#...#.....");

        g1.expandEmptyRowsAndColumns(9);
        assertEquals(1030, g1.calculateSumOfShortestPaths());
    }

    @Test
    public void testGalaxyMapBigger() {
        GalaxyMap g1 = new GalaxyMap();
        g1.readLine("...#......");
        g1.readLine(".......#..");
        g1.readLine("#.........");
        g1.readLine("..........");
        g1.readLine("......#...");
        g1.readLine(".#........");
        g1.readLine(".........#");
        g1.readLine("..........");
        g1.readLine(".......#..");
        g1.readLine("#...#.....");

        g1.expandEmptyRowsAndColumns(99);
        assertEquals(8410, g1.calculateSumOfShortestPaths());
    }
}
