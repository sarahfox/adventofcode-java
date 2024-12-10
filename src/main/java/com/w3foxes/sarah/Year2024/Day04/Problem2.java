package com.w3foxes.sarah.Year2024.Day04;

import java.io.IOException;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
    public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        char[][] grid = FileReaderUtil.readChars(Problem1.class, "Problem1.txt");
        
        System.out.println(searchForXMas(grid));
    }

    private static boolean onEdge(char[][] grid, int row, int col) {
        return row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1;
    }

    public static long searchForXMas(char[][] grid){
        long total = 0l;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'A' && !onEdge(grid, i, j)){
                    total += checkForX(grid, i, j);
                }
            }
        }
        return total;
    }

    public static long checkForX(char[][] grid, int i, int j){
        long total = 0;

        total += checkForDiagonalX(grid, i, j) ? 1 : 0;
 
        return total;
    }

    public static boolean checkForDiagonalX(char[][] grid, int i, int j){
        int topI = i - 1;
        int topJ = j - 1;
        int bottomI = i + 1;
        int bottomJ = j + 1;
        int leftI = i + 1;
        int leftJ = j - 1;
        int rightI = i - 1;
        int rightJ = j + 1;

        return ((grid[topI][topJ] == 'M' && grid[bottomI][bottomJ] == 'S') ||
            (grid[topI][topJ] == 'S' && grid[bottomI][bottomJ] == 'M')) &&
            ((grid[leftI][leftJ] == 'M' && grid[rightI][rightJ] == 'S') ||
            (grid[leftI][leftJ] == 'S' && grid[rightI][rightJ] == 'M'));
    }
}
