package com.w3foxes.sarah.Year2024.Day10;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        int[][] grid = FileReaderUtil.readInts(Problem1.class, "Problem1.txt");
        long total = scoreGrid(grid);

        System.out.println(total);
    }

    public static long scoreGrid(int[][] grid){
        long total = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0){
                    Set<Point> peaks = findPeaksFrom(grid, r, c, 0);
                    total += peaks.size();
                }
            }
        }
        return total;
    }

    public static Set<Point> findPeaksFrom(int[][] grid, int row, int column, int step){
        //System.out.println("numTrails from (" + row + ", " + column + ") value: " + grid[row][column] + " step: " + step);
        // Taken a step off the grid, not a valid trail
        if(!onGrid(grid, row, column)){
            System.out.println("Off grid");
            return new HashSet<>();
        }
        // Trail the wrong slope, not a valid trail
        if(grid[row][column] != step){
            System.out.println("Invalid trail");
            return new HashSet<>();
        }
        // Found the peak
        if(step == 9){
            System.out.println("Found peak");
            Set<Point> peaks = new HashSet<>();
            peaks.add(new Point(row, column));
            return peaks;
        }

        Set<Point> peaks = new HashSet<>();
        peaks.addAll(findPeaksFrom(grid, row + 1, column, step + 1));
        peaks.addAll(findPeaksFrom(grid, row - 1, column, step + 1));
        peaks.addAll(findPeaksFrom(grid, row, column + 1, step + 1));
        peaks.addAll(findPeaksFrom(grid, row, column - 1, step + 1));

        return peaks;
    }

    public static boolean onGrid(int[][] grid, int row, int column){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public record Point(int row, int column){};
}
