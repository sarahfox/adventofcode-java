package com.w3foxes.sarah.Year2023.Day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeMap {
    Map<String, Point> points = new HashMap<>();
    List<Point> onLoop = new ArrayList<>();
    Point snake = null;
    private long lineNumber = 0;

    public void readLine(String line) {
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            Point p = new Point(i, lineNumber, symbol);
            if (p.getPointType() == PointType.SNAKE) {
                snake = p;
            }
            points.put(p.toString(), p);
        }

        lineNumber++;
    }

    public int getSize() {
        return points.size();
    }

    public int countLoopInsides() {
        // The walkToFarthestPoint method should have already been called, so we've got
        // the loop marked out.
        // Pull all the points that aren't in the loop.
        List<Point> notOnLoop = points.values().stream().filter(p -> !onLoop.contains(p)).toList();
        System.out.println("Not on loop: " + notOnLoop.size());
        int totalInside = 0;
        // Figure out if they're inside or outside using the ray tracing algorithm
        // For each one, walk from the point off to the left
        for (Point pointToCheck : notOnLoop) {
            int linesEncountered = 0;
            for (int i = (int) pointToCheck.getX() - 1; i >= 0; i--) {
                // If you encounter a |, L---7, or F---J character (simplify to L and J) add it
                // to the count
                Point possibleIntersection = points.get(i + ", " + pointToCheck.getY());
                if (onLoop.contains(possibleIntersection) && (possibleIntersection.getPointType() == PointType.VERTICAL_PIPE
                        || possibleIntersection.getPointType() == PointType.NORTH_EAST
                        || possibleIntersection.getPointType() == PointType.NORTH_WEST)) {
                    linesEncountered++;
                }
            }
            // When you get to the end, look at the count
            // Odd numbers are inside the loop
            if (linesEncountered % 2 == 1) {
                totalInside++;
            }
            // Even numbers are outside
        }

        return totalInside;
    }

    public long walkToFarthestPoint() {
        // Start at the snake
        // Get the list of exits for the point
        long stepCount = 0;
        List<Point> snakeExitPoints = getExits(snake);
        System.out.println("Snake at: " + snake);
        onLoop.add(snake);

        // Get the exit point's exit points.
        for (Point p : snakeExitPoints) {
            if (p != null) {
                System.out.println("Checking exit: " + p);
                List<Point> checkBack = getExits(p);
                System.out.println(checkBack);
                // Only walk the loop once
                if (checkBack.contains(snake) && stepCount < 1) {
                    stepCount = walkLoop(snake, p, stepCount + 1);
                }
            }
        }
        // If one of those the point you started with?
        // If so, take the other exit.
        // And keep track of how many steps it took to get to this point.
        // If not, the point was connected to something else. Take another exit.
        System.out.println("onLoop size: " + onLoop.size());

        return stepCount;
    }

    public long walkLoop(Point cameFrom, Point current, long stepCount) {
        //System.out.println("Walked to: " + current + " step: " + stepCount);
        // Mark the current step count on the map, if it hasn't already been set.
        // If it has been set, only mark it if it's more than the current step count
        onLoop.add(current);

        if (current.equals(snake)) {
            return stepCount / 2;
        }

        List<Point> exits = getExits(current);
        exits.remove(cameFrom);

        return walkLoop(current, exits.get(0), stepCount + 1);
    }

    public List<Point> getExits(Point p) {
        List<Point> exits = new ArrayList<>();

        switch (p.getPointType()) {
            case GROUND:
                break; // Ground isn't part of a pipe
            case VERTICAL_PIPE: // Exits are up and down
                exits.add(points.get(p.getX() + ", " + (p.getY() + 1)));
                exits.add(points.get(p.getX() + ", " + (p.getY() - 1)));
                break;
            case HORIZONTAL_PIPE:
                exits.add(points.get((p.getX() + 1) + ", " + p.getY()));
                exits.add(points.get((p.getX() - 1) + ", " + p.getY()));
                break;
            case NORTH_EAST:
                exits.add(points.get(p.getX() + ", " + (p.getY() - 1)));
                exits.add(points.get((p.getX() + 1) + ", " + p.getY()));
                break;
            case NORTH_WEST:
                exits.add(points.get(p.getX() + ", " + (p.getY() - 1)));
                exits.add(points.get((p.getX() - 1) + ", " + p.getY()));
                break;
            case SOUTH_EAST:
                exits.add(points.get(p.getX() + ", " + (p.getY() + 1)));
                exits.add(points.get((p.getX() + 1) + ", " + p.getY()));
                break;
            case SOUTH_WEST:
                exits.add(points.get(p.getX() + ", " + (p.getY() + 1)));
                exits.add(points.get((p.getX() - 1) + ", " + p.getY()));
                break;
            case SNAKE:
                exits.add(points.get(p.getX() + ", " + (p.getY() + 1)));
                exits.add(points.get(p.getX() + ", " + (p.getY() - 1)));
                exits.add(points.get((p.getX() + 1) + ", " + p.getY()));
                exits.add(points.get((p.getX() - 1) + ", " + p.getY()));
                break;
        }
        return exits;
    }

}
