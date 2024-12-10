package com.w3foxes.sarah.Year2023.Day13;

import java.util.List;
import java.util.stream.Collectors;

public class SmudgedReflector extends Reflector {
    private boolean[][] grid;

    public SmudgedReflector(Reflector r) {
        super(r.getGrid());
        this.grid = r.getGrid();
    }

    @Override
    public int reflectHorizontal() {
        for(int i = 1; i < grid.length; i++) {
            if(reflectHorizontalDiffs(i) == 1) return i;
        }
        return -1;
    }

    @Override
    public int reflectVertical() {
        for(int i = 1; i < grid[0].length; i++) {
            if(reflectVerticalDiffs(i) == 1) return i;
        }
        return -1;
    }

    private int reflectHorizontalDiffs(int rowsAbove) {
        int errors = 0;
        for(int currentRowAbove = rowsAbove - 1, currentRowBelow = rowsAbove;
            currentRowAbove >= 0 && currentRowBelow < grid.length;
            currentRowAbove--, currentRowBelow++) {
            errors += rowDiffs(currentRowAbove, currentRowBelow);
        }
        return errors;
    }

    private int reflectVerticalDiffs(int colsLeft) {
        int errors = 0;
        for (int currentColLeft = colsLeft - 1, currentColRight = colsLeft;
             currentColLeft >= 0 && currentColRight < grid[0].length;
             currentColLeft--, currentColRight++) {
            errors += colDiffs(currentColLeft, currentColRight);
        }
        return errors;
    }

    public int rowDiffs(int row1, int row2) {
        int errors = 0;
        for(int col = 0; col < grid[row1].length; col++) {
            if(grid[row1][col] != grid[row2][col]) errors++;
        }
        return errors;
    }

    public int colDiffs(int col1, int col2) {
        int errors = 0;
        for(int row = 0; row < grid.length; row++) {
            if(grid[row][col1] != grid[row][col2]) errors++;
        }
        return errors;
    }

    public static List<Reflector> parseList(List<String> input) {
        List<Reflector> reflectors = Reflector.parseList(input);
        return reflectors.stream()
                .map(x -> new SmudgedReflector(x))
                .collect(Collectors.toList());
    }
}