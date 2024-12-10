package com.w3foxes.sarah.Year2024.Day06;

import java.io.IOException;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
    
    public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        Grid grid = new Grid(lines);

        System.out.println(grid.countPossibleLoops());
    }

}
