package com.w3foxes.sarah.Year2024.Day15;

import java.util.ArrayList;
import java.util.List;

import com.w3foxes.sarah.util.Point;

public class Grid {
    private List<List<GridElement>> grid;
    Point robotPosition;
    
    Grid(List<String> lines){
        grid = new ArrayList<>();
        int row = 0;
        int column = 0;

        for(String line : lines){
            if(line.isBlank()){
                break;
            }
            List<GridElement> gridLine = new ArrayList<>();
            column = 0;
            for(char c : line.toCharArray()){
                GridElement g = GridElement.get(c);
                gridLine.add(g);
                if(g == GridElement.ROBOT){
                    robotPosition = new Point(row, column);
                }
                column++;
            }
            grid.add(gridLine);
            row++;
        }
    }

    public void moveRobot(PathElement move){
        if(moveElement(robotPosition, move)){
            // Update robot position
            robotPosition = new Point(robotPosition.row() + move.getRowMove(), robotPosition.column() + move.getColumnMove());
        }
    }

    public boolean moveElement(Point start, PathElement move){
        Point next = new Point(start.row() + move.getRowMove(), start.column() + move.getColumnMove());
        GridElement currentElement = grid.get(start.row()).get(start.column());
        GridElement nextElement = grid.get(next.row()).get(next.column());
        // If next is a wall, the move cannot be done
        if(GridElement.WALL == nextElement){
            return false;
        }
        // If next is open ground, make the move
        if(GridElement.GROUND == nextElement){
            grid.get(next.row()).set(next.column(), currentElement);
            grid.get(start.row()).set(start.column(), GridElement.GROUND);
            return true;
        }
        // If the next element is a box, recurse to try and move it
        if(GridElement.BOX == nextElement){
            if(moveElement(next, move)){
                grid.get(next.row()).set(next.column(), currentElement);
                grid.get(start.row()).set(start.column(), GridElement.GROUND);
                return true;
            }
            // else {
            //     System.out.println("Couldn't move next element (" + next.row() + ", " + next.column());
            // }
        }
        return false;
    }

    public long scoreGrid() {
        long total = 0;

        for(int r = 0; r < grid.size(); r++){
            List<GridElement> row = grid.get(r);
            for(int c = 0; c < row.size(); c++){
                GridElement g = row.get(c);
                if(GridElement.BOX == g){
                    total += 100 * r + c;
                }
            }
        }
        return total;
    }

    public void printGrid() {
        for(List<GridElement> gridList : grid){
            for(GridElement element : gridList){
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }
}
