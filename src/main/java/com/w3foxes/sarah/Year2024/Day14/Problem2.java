package com.w3foxes.sarah.Year2024.Day14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.w3foxes.sarah.util.FileReaderUtil;
import com.w3foxes.sarah.util.Point;

public class Problem2 {

    private static long LOWEST_SAFETY_FACTOR = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        List<Robot> robots = parseRobots(lines);

        // Objective: Find a christmas tree in the pattern of robots
        // How? What does the christmas tree look like?
        // Idea - run the simulation, printing out every now and then when something
        // looks interesting.
        // Need to define interesting.
        int gridRows = 103;
        int gridColumns = 101;
        long seconds = 0;
        while(seconds < (gridColumns * gridRows)){
            Set<Point> occupiedPoints = runRobots(robots, gridRows, gridColumns, seconds);
            if (isInteresting(occupiedPoints, robots.size(), gridRows, gridColumns, seconds)) {
                printSet(occupiedPoints, gridRows, gridColumns, seconds);
            }
            seconds++;
        }
        System.out.println(seconds);
    }

    public static long calculateSafetyFactor(Set<Point> points, int gridRows, int gridColumns){
        Map<Quadrant, Long> quadrantRobotCount = new HashMap<>();
        for(Point p : points){
            Quadrant q = findQuadrant(p, gridRows, gridColumns);
            quadrantRobotCount.put(q, quadrantRobotCount.getOrDefault(q, 0l));
        }

        Quadrant[] validQuadrants = {Quadrant.LOWER_LEFT, Quadrant.LOWER_RIGHT, Quadrant.UPPER_LEFT, Quadrant.UPPER_RIGHT};
        long total = 1;
        for(Quadrant q : validQuadrants){
            long quadrantCount = quadrantRobotCount.getOrDefault(q, 0l);
            total *= quadrantCount;
        }

        return total;
    }

    public static Quadrant findQuadrant(Point p, long gridRows, long gridColumns){
        if(p.row() < gridRows / 2){
            if(p.column() < gridColumns / 2){
                return Quadrant.UPPER_LEFT;
            }
            else if(p.column() > gridColumns / 2){
                return Quadrant.UPPER_RIGHT;
            }
            else {
                return Quadrant.NONE;
            }
        }
        else if(p.row() > gridRows / 2){
            if(p.column() < gridColumns / 2){
                return Quadrant.LOWER_LEFT;
            }
            else if(p.column() > gridColumns / 2){
                return Quadrant.LOWER_RIGHT;
            }
        }
        return Quadrant.NONE;
    }

    public static void printSet(Set<Point> occupiedPoints, int gridRows, int gridColumns, long seconds) {

        System.out.println("seconds: " + seconds);
        for(int r = 0; r < gridRows; r++){
            StringBuffer sb = new StringBuffer();
            for(int c = 0; c < gridColumns; c++){
                if(occupiedPoints.contains(new Point(r, c))){
                    sb.append("R");
                }
                else {
                    sb.append(".");
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static boolean isInteresting(Set<Point> occupiedPoints, int numRobots, int gridRows, int gridColumns,
            long seconds) {
        // I went and looked at spoilers, since I've got no idea how to approach this.
        // Looking for none of the robots being on top of each other was recommended.
        // Also looking at multiples of 103 or 101
        // Some people said to look for a new lowest safety factor
        long safetyFactor = calculateSafetyFactor(occupiedPoints, gridRows, gridColumns);
        if(safetyFactor < LOWEST_SAFETY_FACTOR){
            LOWEST_SAFETY_FACTOR = safetyFactor;
            return true;
        }
        if (occupiedPoints.size() == numRobots) {
            return true;
        }
        // if (seconds % gridRows == 0 || seconds % gridColumns == 0) {
        //     return true;
        // }

        return false;
    }

    // Let's only do the parsing once - it's expensive
    public static List<Robot> parseRobots(List<String> lines) {
        List<Robot> robots = new ArrayList<>();
        for (String line : lines) {
            Robot r = new Robot(line);
            robots.add(r);
        }
        return robots;
    }

    public static Set<Point> runRobots(List<Robot> robots, long gridRows, long gridColumns, long seconds) {
        Set<Point> occupiedPoints = new HashSet<>();

        for (Robot r : robots) {
            Point p = r.run(gridRows, gridColumns, seconds);
            occupiedPoints.add(p);
        }

        return occupiedPoints;
    }
}
