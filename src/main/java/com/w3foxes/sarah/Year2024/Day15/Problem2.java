package com.w3foxes.sarah.Year2024.Day15;

import java.io.IOException;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
    
    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");

        ExtendedGrid grid = new ExtendedGrid(lines);
        Path path = new Path(lines);

        moveBoxes(grid, path);

        System.out.println(grid.scoreGrid());
    }

    public static void moveBoxes(ExtendedGrid grid, Path path) {
        for (PathElement p : path.getPath()) {
            grid.moveRobot(p);
            // System.out.println("Move: " + p.getSymbol());
            // grid.printGrid();
        }
    }

}
