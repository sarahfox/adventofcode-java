package com.w3foxes.sarah.Year2023.Day13;

import java.util.ArrayList;
import java.util.List;

public class Reflector {
    private boolean grid[][];
    public Reflector(List<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        grid = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                grid[row][col] = input.get(row).charAt(col) == '#';
            }
        }
    }
    public Reflector(boolean[][] grid) {
        this.grid = grid;
    }

    public int reflectHorizontal() {
        for(int i = 1; i < grid.length; i++) {
            if(reflectsHorizontal(i)) return i;
        }
        return -1;
    }

    public int reflectVertical() {
        for(int i = 1; i < grid[0].length; i++) {
            if(reflectsVertical(i)) return i;
        }
        return -1;
    }

    private boolean reflectsHorizontal(int rowsAbove) {
        for(int currentRowAbove = rowsAbove - 1, currentRowBelow = rowsAbove;
            currentRowAbove >= 0 && currentRowBelow < grid.length;
            currentRowAbove--, currentRowBelow++) {
            if(! rowsEqual(currentRowAbove, currentRowBelow)) return false;
        }
        return true;
    }

    private boolean reflectsVertical(int colsLeft) {
        for (int currentColLeft = colsLeft - 1, currentColRight = colsLeft;
             currentColLeft >= 0 && currentColRight < grid[0].length;
             currentColLeft--, currentColRight++) {
            if( !colsEqual(currentColLeft, currentColRight)) return false;
        }
        return true;
    }

    public boolean rowsEqual(int row1, int row2) {
        for(int col = 0; col < grid[row1].length; col++) {
            if(grid[row1][col] != grid[row2][col]) return false;
        }
        return true;
    }

    public boolean colsEqual(int col1, int col2) {
        for(int row = 0; row < grid.length; row++) {
            if(grid[row][col1] != grid[row][col2]) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                sb.append(grid[row][col] ? '#' : '.');
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public static List<Reflector> parseList(List<String> input) {
        List<Reflector> result = new ArrayList<>();
        List<String> currentLines = new ArrayList<>();

        for(String line : input) {
            if(line.isEmpty() && !currentLines.isEmpty()) {
                result.add(new Reflector(currentLines));
                currentLines = new ArrayList<>();
            } else {
                currentLines.add(line);
            }
        }
        if(!currentLines.isEmpty()) {
            result.add(new Reflector(currentLines));
        }
        return result;
    }

    public static long computeResult(List<Reflector> reflectors) {
        long result = 0;
        for(Reflector r : reflectors) {
            long numCols = r.reflectVertical();
            if(numCols != -1) {
                System.out.println(numCols);
                result += numCols;
            } else {
                long numRows = r.reflectHorizontal();
                System.out.println((numRows * 100));
                result += numRows * 100;
            }
        }
        return result;
    }
}