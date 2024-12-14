package com.w3foxes.sarah.Year2024.Day14;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.w3foxes.sarah.util.FileReaderUtil;
import com.w3foxes.sarah.util.Point;

public class Problem1 {
        
        public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        long gridRows = 103;
        long gridColumns = 101;
        long seconds = 100;
        Map<Quadrant, Long> quadrantRobotCount = runRobots(lines, gridRows, gridColumns, seconds);
        long total = calculateSafetyFactor(quadrantRobotCount);

        System.out.println(total);
    }

    public static long calculateSafetyFactor(Map<Quadrant, Long> quadrantRobotCount){
        Quadrant[] validQuadrants = {Quadrant.LOWER_LEFT, Quadrant.LOWER_RIGHT, Quadrant.UPPER_LEFT, Quadrant.UPPER_RIGHT};
        long total = 1;
        for(Quadrant q : validQuadrants){
            long quadrantCount = quadrantRobotCount.getOrDefault(q, 0l);
            total *= quadrantCount;
        }

        return total;
    }

    public static Map<Quadrant, Long> runRobots(List<String> lines, long gridRows, long gridColumns, long seconds){
        Map<Quadrant, Long> quadrantRobotCount = new HashMap<>();

        for(String line : lines){
            Robot r = new Robot(line);
            Point p = r.run(gridRows, gridColumns, seconds);
            Quadrant q = findQuadrant(p, gridRows, gridColumns);
            //System.out.println("Point (" + p.row() + ", " + p.column() + "), quadrant: " + q);
            quadrantRobotCount.put(q, quadrantRobotCount.getOrDefault(q, 0l) + 1);
        }

        return quadrantRobotCount;
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
}
