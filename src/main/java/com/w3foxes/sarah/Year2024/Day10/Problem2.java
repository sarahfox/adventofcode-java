package com.w3foxes.sarah.Year2024.Day10;

import java.io.IOException;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {

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
                    total += findRatingFrom(grid, r, c, 0);
                }
            }
        }
        return total;
    }

    public static long findRatingFrom(int[][] grid, int row, int column, int step){
        // Taken a step off the grid, not a valid trail
        if(!onGrid(grid, row, column)){
            return 0;
        }
        // Trail the wrong slope, not a valid trail
        if(grid[row][column] != step){
            return 0;
        }
        // Found the peak
        if(step == 9){
            return 1;
        }

        long total = 0;
        total += findRatingFrom(grid, row + 1, column, step + 1);
        total += findRatingFrom(grid, row - 1, column, step + 1);
        total += findRatingFrom(grid, row, column + 1, step + 1);
        total += findRatingFrom(grid, row, column - 1, step + 1);

        return total;
    }

    public static boolean onGrid(int[][] grid, int row, int column){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public record Point(int row, int column){};
}
