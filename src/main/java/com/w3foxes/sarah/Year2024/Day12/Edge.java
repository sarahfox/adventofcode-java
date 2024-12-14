package com.w3foxes.sarah.Year2024.Day12;

import com.w3foxes.sarah.util.Point;

public class Edge {
    Point p;
    Direction d;

    Edge(Point p, Direction d){
        this.p = p;
        this.d = d;
    }

    public Point getP() {
        return p;
    }

    public Direction getD() {
        return d;
    }
    
}
