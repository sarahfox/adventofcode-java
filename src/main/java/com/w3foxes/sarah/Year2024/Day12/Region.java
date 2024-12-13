package com.w3foxes.sarah.Year2024.Day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Region {
    char id;
    Set<Point> points;
    long perimeter;
    Set<Edge> edges;

    public Region(char id) {
        this.id = id;
        points = new HashSet<>();
        perimeter = 0;
        edges = new HashSet<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void incrementPerimeter() {
        perimeter++;
    }

    public long getPerimeter() {
        return perimeter;
    }

    public long getArea() {
        return points.size();
    }

    public char getId() {
        return id;
    }

    public long countSides() {
        long total = 0;
        // Each edge is added to the list for a direction
        List<Point> upEdges = new ArrayList<>();
        List<Point> downEdges = new ArrayList<>();
        List<Point> leftEdges = new ArrayList<>();
        List<Point> rightEdges = new ArrayList<>();
        for (Edge e : edges) {
            switch (e.getD()) {
                case UP:
                    upEdges.add(e.getP());
                    break;
                case DOWN:
                    downEdges.add(e.getP());
                    break;
                case LEFT:
                    leftEdges.add(e.getP());
                    break;
                case RIGHT:
                    rightEdges.add(e.getP());
                    break;
            }
        }

        total += countHorizontalEdges(upEdges);
        total += countHorizontalEdges(downEdges);
        total += countVerticalEdges(leftEdges);
        total += countVerticalEdges(rightEdges);

        return total;
    }

    private long countHorizontalEdges(List<Point> horizontalEdges){
        // Sort the edges by row or column, depending on direction
        Collections.sort(horizontalEdges, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.row() != p2.row()){
                    return Integer.compare(p1.row(), p2.row());
                }
                return Integer.compare(p1.column(), p2.column());
            }
        });
        long total = 0;

        // The iterate through the lists, counting up the gaps
        Point lastPoint = new Point(-1, -2);
        for(Point p : horizontalEdges){
            // If we've jumped a row, it's a new edge
            if(p.row() != lastPoint.row()){
                total++;
            }
            // If it's the same row, but the column is > 1 step away, it's a new edge
            else if(p.column() != lastPoint.column() + 1){
                total++;
            }
            lastPoint = p;
        }
        
        return total;
    }

    private long countVerticalEdges(List<Point> verticalEdges){
        // Sort the edges by row or column, depending on direction
        Collections.sort(verticalEdges, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.column() != p2.column()){
                    return Integer.compare(p1.column(), p2.column());
                }
                return Integer.compare(p1.row(), p2.row());
            }
        });
        long total = 0;

        // The iterate through the lists, counting up the gaps
        Point lastPoint = new Point(-1, -2);
        for(Point p : verticalEdges){
            // If we've jumped a column, it's a new edge
            if(p.column() != lastPoint.column()){
                total++;
            }
            // If it's the same column, but the row is > 1 step away, it's a new edge
            else if(p.row() != lastPoint.row() + 1){
                total++;
            }
            lastPoint = p;
        }
        
        return total;
    }
}
