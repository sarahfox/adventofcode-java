package com.w3foxes.sarah.Year2023.Day16;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EnergyGridTest {
    @Test
    public void testCreateSimpleEnergyGrid() {
        List<String> lines = Arrays.asList(".|.", "|..", "\\-/");
        EnergyGrid grid = new EnergyGrid(lines);

        System.out.println(grid);
        grid.lightUp(0, 0, BeamDirection.RIGHT);
        assertEquals(9, grid.countLightedSquares());
    }

    @Test
    public void testCreateEnergyGrid() {
       List<String> lines = Arrays.asList(".|...\\....", 
            "|.-.\\.....", 
            ".....|-...", 
            "........|.", 
            "..........", 
            ".........\\",
            "..../.\\\\..", 
            ".-.-/..|..", 
            ".|....-|.\\", 
            "..//.|....");
        EnergyGrid grid = new EnergyGrid(lines);

        System.out.println(grid);
        grid.lightUp(0, 0, BeamDirection.RIGHT);
        assertEquals(46, grid.countLightedSquares());
    }
}
