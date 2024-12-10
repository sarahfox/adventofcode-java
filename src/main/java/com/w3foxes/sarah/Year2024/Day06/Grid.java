package com.w3foxes.sarah.Year2024.Day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
    private char[][] grid;
    private Point guardPosition;
    private Point originalGuardPosition;
    private Set<PointAndDirection> visitedSet = new HashSet<>();
    private Set<Point> visitedPoints = new HashSet<>();
    private Direction guardDirection = Direction.UP;

    public Grid(List<String> lines) {
        int rows = lines.size();
        int columns = lines.get(0).length();

        grid = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = lines.get(i).charAt(j);
                if (grid[i][j] == '^') {
                    guardPosition = new Point(i, j);
                    originalGuardPosition = new Point(i, j);
                    visitedSet.add(new PointAndDirection(guardPosition, guardDirection));
                    visitedPoints.add(guardPosition);
                }
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public Point getGuardPosition() {
        return guardPosition;
    }

    public Set<Point> getVisitedPoints() {
        return visitedPoints;
    }

    public void walkGrid() {
        visitedPoints = new HashSet<>();
        visitedPoints.add(originalGuardPosition);
        visitedSet = new HashSet<>();
        visitedSet.add(new PointAndDirection(originalGuardPosition, Direction.UP));
        guardPosition = originalGuardPosition;
        guardDirection = Direction.UP;
        
         Point nextPoint = new Point(guardPosition.getRow() + guardDirection.getNextRowStep(),
                guardPosition.getColumn() + guardDirection.getNextColumnStep());
        while (isOnMap(nextPoint)) {
            // System.out.println("Next point row: " + nextPoint.getRow() + " column: " +
            // nextPoint.getColumn());
            // If the next point is an obstruction, turn
            if (grid[nextPoint.getRow()][nextPoint.getColumn()] == '#') {
                switch (guardDirection) {
                    case Direction.DOWN:
                        guardDirection = Direction.LEFT;
                        break;
                    case Direction.LEFT:
                        guardDirection = Direction.UP;
                        break;
                    case Direction.UP:
                        guardDirection = Direction.RIGHT;
                        break;
                    case Direction.RIGHT:
                        guardDirection = Direction.DOWN;
                        break;
                }
                // System.out.println("Turning " + guardDirection);
            }
            // If clear, the guard moves there
            else {
                guardPosition = nextPoint;
                visitedSet.add(new PointAndDirection(guardPosition, guardDirection));
                visitedPoints.add(guardPosition);
            }

            nextPoint = new Point(guardPosition.getRow() + guardDirection.nextRowStep,
                    guardPosition.getColumn() + guardDirection.getNextColumnStep());
        }
        // System.out.println("Row: " + nextPoint.getRow() + " column: " +
        // nextPoint.getColumn() + " is off the map.");
    }

    public boolean walkGridWithLoopDetection() {
        visitedPoints = new HashSet<>();
        visitedPoints.add(originalGuardPosition);
        visitedSet = new HashSet<>();
        visitedSet.add(new PointAndDirection(originalGuardPosition, Direction.UP));
        guardPosition = originalGuardPosition;
        guardDirection = Direction.UP;

        Point nextPoint = new Point(guardPosition.getRow() + guardDirection.getNextRowStep(),
                guardPosition.getColumn() + guardDirection.getNextColumnStep());
        while (isOnMap(nextPoint)) {
            // If we've already visited this point in this direction before, return true,
            // there is a loop
            if (visitedSet.contains(new PointAndDirection(nextPoint, guardDirection))) {
                return true;
            }
            // System.out.println("Next point row: " + nextPoint.getRow() + " column: " +
            // nextPoint.getColumn());
            // If the next point is an obstruction, turn
            if (grid[nextPoint.getRow()][nextPoint.getColumn()] == '#') {
                switch (guardDirection) {
                    case Direction.DOWN:
                        guardDirection = Direction.LEFT;
                        break;
                    case Direction.LEFT:
                        guardDirection = Direction.UP;
                        break;
                    case Direction.UP:
                        guardDirection = Direction.RIGHT;
                        break;
                    case Direction.RIGHT:
                        guardDirection = Direction.DOWN;
                        break;
                }
                // System.out.println("Turning " + guardDirection);
            }
            // If clear, the guard moves there
            else {
                guardPosition = nextPoint;
                visitedSet.add(new PointAndDirection(guardPosition, guardDirection));
                visitedPoints.add(guardPosition);
            }

            nextPoint = new Point(guardPosition.getRow() + guardDirection.nextRowStep,
                    guardPosition.getColumn() + guardDirection.getNextColumnStep());
        }
        return false;
        // System.out.println("Row: " + nextPoint.getRow() + " column: " +
        // nextPoint.getColumn() + " is off the map.");
    }

    public long countPossibleLoops() {
        long total = 0l;

        // Try every position on the grid, place an obstruction on it if it's a clear
        // spot
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '.') {
                    grid[r][c] = '#';
                    // Walk the grid and see if there's a loop
                    boolean isLoop = walkGridWithLoopDetection();
                    if (isLoop) {
                        total++;
                    }
                    // Remove the obstruction
                    grid[r][c] = '.';
                }
            }
        }

        return total;
    }

    public boolean isOnMap(Point nextPoint) {
        return nextPoint.getRow() >= 0 && nextPoint.getRow() < grid.length && nextPoint.getColumn() >= 0
                && nextPoint.getColumn() < grid[0].length;
    }

    public record PointAndDirection(Point point, Direction direction) {
    }
}
