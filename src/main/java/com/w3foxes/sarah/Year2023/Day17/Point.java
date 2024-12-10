package com.w3foxes.sarah.Year2023.Day17;

import java.util.Objects;

public class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return getX() + ", " + getY();
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Point comparedTo = (Point) o;
        // field comparison
        return Objects.equals(x, comparedTo.x)
                && Objects.equals(y, comparedTo.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point p){
        if(this.equals(p)){
            return 0;
        }
        else {
            if(p.x != this.x){
                return (this.x < p.x) ? -1 : ((this.x == p.x) ? 0 : 1);
            }

            return (this.y < p.y) ? -1 : ((this.y == p.y) ? 0 : 1);
        }
    }
}
