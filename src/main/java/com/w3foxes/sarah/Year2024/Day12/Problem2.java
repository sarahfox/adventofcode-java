package com.w3foxes.sarah.Year2024.Day12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.w3foxes.sarah.util.FileReaderUtil;
import com.w3foxes.sarah.util.Point;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        char[][] grid = FileReaderUtil.readChars(Problem1.class, "Problem1.txt");
        long total = calculateFencingCosts(grid);

        System.out.println(total);
    }

    // Let's think about data structures. We'll need to keep a list of regions we've
    // already defined, mapped by the points within the region.
    // So we can say Point(1,2) -> Region G, Point(1,4) -> Region H
    // Then each region keeps track of what points it's got (do we need that, or
    // just the total area so far?) and the perimeter.
    // If we look up a point in the points map and it's not there but the letter is
    // the same, it's in the same region, we just haven't got there yet.
    // I suspect part 2 is going to be deduping fences, not sure how that's going to
    // be done. So don't worry about it for now. No need to borrow trouble.

    public static List<Point> lookAround(int row, int column){
        Point up = new Point(row - 1, column);
        Point down = new Point(row + 1, column);
        Point left = new Point(row, column - 1);
        Point right = new Point(row, column + 1);

        return Arrays.asList(up, down, left, right);
    }

    public static long calculateFencingCosts(char[][] grid) {
        long total = 0;
        List<Region> regions = new ArrayList<>();
        Map<Point, Region> lookup = new HashMap<>();

        // For each spot on the grid
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                // See if the point is already in a region
                Point currentPoint = new Point(row, column);
                Region r = lookup.get(currentPoint);

                // What if we find multiple regions?  Like say the region has a jog to the left on a new line.  
                // We're only looking in the immediate area, so would miss that there's already a region, 
                // but it's 2 squares away from where we currently are.
                // 2 ideas - 1) Change the algorigthm to crawl out when we find a new region.  Make sure a region is completely added.  Then continue walking the grid
                // 2) Combine regions when 2 or more are found.  That would require updating the lookup map and the list of regions.  Not sure about that.
                // With 1), if we hit a point that's not in the lookup map, we know we're in a new region.  That actually works for me.

                // If we can't find a matching , start a new region with
                // this point
                if (r == null) {
                    //System.out.println("New region: " + grid[row][column]);
                    r = new Region(grid[row][column]);
                    regions.add(r);
                    crawlRegion(grid, currentPoint, lookup, r);
                }
            }
        }

        // Total up the costs
        for(Region r : regions){
            //System.out.println("Region " + r.getId() + " area: " + r.getArea() + " perimeter: " + r.getPerimeter());
            total += r.getArea() * r.countSides();
        }

        return total;
    }

    public static void crawlRegion(char[][] grid, Point start, Map<Point, Region> lookup, Region r){
        Stack<Point> toCheck = new Stack<>();
        toCheck.add(start);

        while(toCheck.size() > 0){
            Point pointToCheck = toCheck.pop();
            //System.out.println("Checking (" + pointToCheck.row() + "," + pointToCheck.column() + ") against region " + r.getId());
            if(isValidPoint(grid, pointToCheck) && !lookup.containsKey(pointToCheck) && grid[pointToCheck.row()][pointToCheck.column()] == r.getId()){
                //System.out.println("In region");
                List<Point> pointsAround = lookAround(pointToCheck.row(), pointToCheck.column());
                toCheck.addAll(pointsAround);
                lookup.put(pointToCheck, r);
                r.addPoint(pointToCheck);

                // Check and see if we need to update the perimeter too
                for(Point adjacent : pointsAround){
                    if(!isValidPoint(grid, adjacent) || grid[adjacent.row()][adjacent.column()] != r.getId()){
                        r.incrementPerimeter();
                        Direction direction = figureDirection(pointToCheck, adjacent);
                        r.addEdge(new Edge(pointToCheck, direction));
                    }
                }
            }
        }
    }

    public static Direction figureDirection(Point pointToCheck, Point adjacent){
        if(pointToCheck.row() == adjacent.row()){
            if(pointToCheck.column() > adjacent.column()){
                return Direction.LEFT;
            }
            else {
                return Direction.RIGHT;
            }
        }
        else {
            if(pointToCheck.row() > adjacent.row()){
                return Direction.UP;
            }
            else {
                return Direction.DOWN;
            }
        }
    }

    public static boolean isValidPoint(char[][] grid, Point p){
        return p.row() >= 0 && p.row() < grid.length && p.column() >= 0 && p.column() < grid[0].length;
    }
}
