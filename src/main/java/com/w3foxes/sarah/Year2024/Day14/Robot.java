package com.w3foxes.sarah.Year2024.Day14;

import com.w3foxes.sarah.util.Constants;
import com.w3foxes.sarah.util.Point;

public class Robot {
    Point start;
    Point velocity;

    Robot(String input){
        String[] parts = input.split(Constants.WHITESPACE_REGEX);
        String[] startParts = parts[0].split("\\=")[1].trim().split(",");
        start = new Point(Integer.parseInt(startParts[1]), Integer.parseInt(startParts[0]));
        String[] velocityParts = parts[1].split("\\=")[1].trim().split(",");
        velocity = new Point(Integer.parseInt(velocityParts[1]), Integer.parseInt(velocityParts[0]));
    }

    public Point run(long gridRows, long gridColumns, long numSeconds){
        // Take the start point, multiply the velocity by the number of seconds, then modulo the grid size
        long newRow = (start.row() + (velocity.row() * numSeconds)) % gridRows;
        if(newRow < 0){
            newRow += gridRows;
        }
        long newColumn = (start.column() + (velocity.column() * numSeconds)) % gridColumns;
        if(newColumn < 0){
            newColumn += gridColumns;
        }
        
        return new Point((int) newRow, (int) newColumn);
    }
}
