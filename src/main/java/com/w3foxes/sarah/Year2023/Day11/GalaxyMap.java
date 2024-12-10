package com.w3foxes.sarah.Year2023.Day11;

import java.util.ArrayList;
import java.util.List;

public class GalaxyMap {
    List<Point> galaxies = new ArrayList<>();
    int galaxyMaxX = 0;
    int galaxyMaxY = 0;

    public void readLine(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '#') {
                galaxies.add(new Point(i, galaxyMaxY));
            }
        }

        galaxyMaxX = line.length();
        galaxyMaxY++;
    }

    public void expandEmptyRowsAndColumns(int expansionFactor) {
        // If we find an empty row or column, shift the coordinates of everyone beyond
        // that empty row or column down by 1
        List<Integer> emptyColumns = new ArrayList<>();
        List<Integer> emptyRows = new ArrayList<>();
        int timesColumnsIncremented = 0;
        int timesRowsIncremented = 0;

        for (int i = 0; i < galaxyMaxX; i++) {
            if (columnIsEmpty(i)) {
                System.out.println("Column " + i + " is empty");
                emptyColumns.add(i);
            }
        }
        for (int j = 0; j < galaxyMaxY; j++) {
            if (rowIsEmpty(j)) {
                System.out.println("Row " + j + " is empty");
                emptyRows.add(j);
            }
        }

        for (int columnIndex : emptyColumns) {
            incrementXCoordinatesBeyondThisColumn(columnIndex + expansionFactor * timesColumnsIncremented, expansionFactor);
            timesColumnsIncremented++;
        }
        for (int rowIndex : emptyRows) {
            incrementYCoordinatesBeyondThisRow(rowIndex + expansionFactor * timesRowsIncremented, expansionFactor);
            timesRowsIncremented++;
        }
    }

    public boolean columnIsEmpty(int column) {
        return galaxies.stream().noneMatch(n -> n.getX() == column);
    }

    public boolean rowIsEmpty(int row) {
        return galaxies.stream().noneMatch(n -> n.getY() == row);
    }

    public void incrementXCoordinatesBeyondThisColumn(int column, int expansionFactor) {
        galaxies.stream().filter(n -> n.getX() > column).forEach(n -> n.incrementX(expansionFactor));
    }

    public void incrementYCoordinatesBeyondThisRow(int row, int expansionFactor) {
        galaxies.stream().filter(n -> n.getY() > row).forEach(n -> n.incrementY(expansionFactor));
    }

    public long calculateSumOfShortestPaths() {
        long sum = 0;

        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                Point galaxy1 = galaxies.get(i);
                Point galaxy2 = galaxies.get(j);

                long distance = calculateDistanceBetweenGalaxies(galaxy1, galaxy2);

                System.out.println("Distance between " + galaxy1 + " and " + galaxy2 + " is: " + distance);

                sum += distance;
            }
        }
        return sum;
    }

    public long calculateDistanceBetweenGalaxies(Point g1, Point g2) {
        // Looks like they're asking for the manhattan distance, which'll just be |g1.x
        // - g2.x| + |g1.y - g2.y|
        return Math.abs(g1.getX() - g2.getX()) + Math.abs(g1.getY() - g2.getY());
    }
}
