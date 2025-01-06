package com.w3foxes.sarah.Year2024.Day15;

import java.util.ArrayList;
import java.util.List;

import com.w3foxes.sarah.util.Point;

public class ExtendedGrid {
    private List<List<GridElement>> grid;
    Point robotPosition;

    ExtendedGrid(List<String> lines) {
        grid = new ArrayList<>();
        int row = 0;
        int column = 0;

        for (String line : lines) {
            if (line.isBlank()) {
                break;
            }
            List<GridElement> gridLine = new ArrayList<>();
            column = 0;
            for (char c : line.toCharArray()) {
                GridElement g = GridElement.get(c);
                // If it's a wall or ground, double it
                if (GridElement.WALL == g || GridElement.GROUND == g) {
                    gridLine.add(g);
                    gridLine.add(g);
                }
                // If it's a box, it splits into a left and right half
                if (GridElement.BOX == g) {
                    gridLine.add(GridElement.LEFT_BOX);
                    gridLine.add(GridElement.RIGHT_BOX);
                }
                if (g == GridElement.ROBOT) {
                    robotPosition = new Point(row, column);
                    gridLine.add(g);
                    gridLine.add(GridElement.GROUND);
                }
                column += 2;
            }
            grid.add(gridLine);
            row++;
        }
    }

    public void moveRobot(PathElement move) {
        //System.out.println("Move: " + move);
        if (canMoveElement(robotPosition, move)) {
            moveElement(robotPosition, move);
            // Update robot position
            robotPosition = new Point(robotPosition.row() + move.getRowMove(),
                    robotPosition.column() + move.getColumnMove());
        }
        // printGrid();
        // try {
        //     Thread.sleep(100);
        // } catch (InterruptedException e) {
        //     // Don't care, just trying to slow it down so I can see what's happening.
        // }
    }

    public boolean isValidPoint(Point p) {
        if (p.row() < 0 || p.column() < 0) {
            return false;
        }
        if (p.row() >= grid.size() || p.column() >= grid.get(0).size()) {
            return false;
        }

        return true;
    }

    // Need to check if the move can be made separately now, since there are two
    // parts to boxes that need to move as a unit.
    public boolean canMoveElement(Point start, PathElement move) {
        Point next = new Point(start.row() + move.getRowMove(), start.column() + move.getColumnMove());
        if (!isValidPoint(next)) {
            return false;
        }

        GridElement currentElement = grid.get(start.row()).get(start.column());
        // if (move == PathElement.UP) {
        //     System.out.println("Checking moving: " + currentElement + " from: " + start + " to " + next);
        // }

        // If the current element is open ground, the move is ok
        if (currentElement == GridElement.GROUND) {
            // if (move == PathElement.UP) {
            //     System.out.println("true, this element is open");
            // }
            return true;
        }

        GridElement nextElement = grid.get(next.row()).get(next.column());
        // If the current element is not a box, we can just check if the next element is
        // ground, wall, or can move
        // Actually, moving left or right, the rules are the same for boxes
        if ((currentElement != GridElement.LEFT_BOX && currentElement != GridElement.RIGHT_BOX) ||
                (move == PathElement.LEFT || move == PathElement.RIGHT)) {
            if (nextElement == GridElement.WALL) {
                // if (move == PathElement.UP) {
                //     System.out.println("false, next element is a wall");
                // }
                return false;
            }
            if (nextElement == GridElement.GROUND) {
                // if (move == PathElement.UP) {
                //     System.out.println("true, next element is open");
                // }
                return true;
            }
            boolean canMoveNextElement = canMoveElement(next, move);
            // if (move == PathElement.UP) {
            //     System.out.println(canMoveNextElement + ", checked next element");
            // }
            return canMoveNextElement;
        }
        // Now we're moving up or down, so if the current element is part of a box,
        // we'll need to check if the other side of the box can move too.
        else if (currentElement == GridElement.LEFT_BOX || currentElement == GridElement.RIGHT_BOX) {
            Point otherBoxPoint = new Point(start.row(),
                    start.column() + (currentElement == GridElement.LEFT_BOX ? 1 : -1));
            Point otherBoxNext = new Point(otherBoxPoint.row() + move.getRowMove(),
                    otherBoxPoint.column() + move.getColumnMove());
            if (!isValidPoint(otherBoxPoint) || !isValidPoint(otherBoxNext)) {
                // if (move == PathElement.UP) {
                //     System.out
                //             .println("false, going off the map for points: " + otherBoxPoint + " and " + otherBoxNext);
                // }
                return false;
            }
            GridElement otherBoxNextElement = grid.get(otherBoxNext.row()).get(otherBoxNext.column());
            if (nextElement == GridElement.WALL || otherBoxNextElement == GridElement.WALL) {
                // if (move == PathElement.UP) {
                //     System.out.println("false, wall at one of: " + otherBoxPoint + " and " + otherBoxNext);
                // }
                return false;
            }
            if (nextElement == GridElement.GROUND && otherBoxNextElement == GridElement.GROUND) {
                // if (move == PathElement.UP) {
                //     System.out.println("true, open ground at points: " + otherBoxPoint + " and " + otherBoxNext);
                // }
                return true;
            }
            // One or the other is not ground
            if (nextElement == GridElement.GROUND) {
                boolean canMoveotherNextElement = canMoveElement(otherBoxNext, move);
                // if (move == PathElement.UP) {
                //     System.out.println(canMoveotherNextElement + ", checked other next element");
                // }
                return canMoveotherNextElement;
            } else if (otherBoxNextElement == GridElement.GROUND) {
                boolean canMoveNextElement = canMoveElement(next, move);
                // if (move == PathElement.UP) {
                //     System.out.println(canMoveNextElement + ", checked next element");
                // }
                return canMoveNextElement;
            } else {
                boolean canMoveotherNextElement = canMoveElement(otherBoxNext, move);
                boolean canMoveNextElement = canMoveElement(next, move);
                // if (move == PathElement.UP) {
                //     System.out.println("canMoveNextElement: " + canMoveNextElement + " canMoveOtherNextElement: "
                //             + canMoveotherNextElement);
                // }
                return canMoveNextElement && canMoveotherNextElement;
            }
        }

        return false;

    }

    // Split detecting if we can move the element from doing the move. Boxes move in
    // two parts, so we don't want one half to move while the other isn't able to.
    // Precondition: canMoveElement has already been called to make sure a move is
    // legal.
    public void moveElement(Point start, PathElement move) {
        Point next = new Point(start.row() + move.getRowMove(), start.column() + move.getColumnMove());
        // System.out.println("Moving " + start + " to " + next);
        GridElement currentElement = grid.get(start.row()).get(start.column());
        if(currentElement == GridElement.GROUND){
            return;
        }

        GridElement nextElement = grid.get(next.row()).get(next.column());

        // If the current element is not a box, we can just check if the next element is
        // ground, wall, or can move
        // Actually, moving left or right, the rules are the same for boxes
        if ((currentElement != GridElement.LEFT_BOX && currentElement != GridElement.RIGHT_BOX) ||
                (move == PathElement.LEFT || move == PathElement.RIGHT)) {
            if (nextElement == GridElement.WALL) {
                // Shouldn't hit this - we've already checked if the element can move
                return;
            }
            else if (nextElement != GridElement.GROUND) {
                moveElement(next, move);
            }
            grid.get(next.row()).set(next.column(), currentElement);
            grid.get(start.row()).set(start.column(), GridElement.GROUND);
            return;
        }
        // Now we're moving up or down, so if the current element is part of a box,
        // we'll need to move the other side too
        else if (currentElement == GridElement.LEFT_BOX || currentElement == GridElement.RIGHT_BOX) {
            Point otherBoxPoint = new Point(start.row(),
                    start.column() + (currentElement == GridElement.LEFT_BOX ? 1 : -1));
            GridElement otherBoxElement = grid.get(otherBoxPoint.row()).get(otherBoxPoint.column());
            Point otherBoxNext = new Point(otherBoxPoint.row() + move.getRowMove(),
                    otherBoxPoint.column() + move.getColumnMove());
            if (!isValidPoint(otherBoxPoint) || !isValidPoint(otherBoxNext)) {
                return;
            }
            if (nextElement == GridElement.WALL) {
                return;
            }
            if (nextElement != GridElement.GROUND) {
                moveElement(next, move);
            }
            grid.get(next.row()).set(next.column(), currentElement);
            grid.get(start.row()).set(start.column(), GridElement.GROUND);

            // And then move the other side
            GridElement otherBoxNextElement = grid.get(otherBoxPoint.row()).get(otherBoxPoint.column());
            if (otherBoxNextElement == GridElement.WALL) {
                return;
            }
            if (otherBoxNextElement != GridElement.GROUND) {
                moveElement(otherBoxNext, move);
            }
            grid.get(otherBoxNext.row()).set(otherBoxNext.column(), otherBoxElement);
            grid.get(otherBoxPoint.row()).set(otherBoxPoint.column(), GridElement.GROUND);
        }
    }

    public long scoreGrid() {
        long total = 0;

        for (int r = 0; r < grid.size(); r++) {
            List<GridElement> row = grid.get(r);
            for (int c = 0; c < row.size(); c++) {
                GridElement g = row.get(c);
                if (GridElement.LEFT_BOX == g) {
                    total += 100 * r + c;
                }
            }
        }
        return total;
    }

    public void printGrid() {
        for (List<GridElement> gridList : grid) {
            for (GridElement element : gridList) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }
}
