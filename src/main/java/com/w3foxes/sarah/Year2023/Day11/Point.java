package com.w3foxes.sarah.Year2023.Day11;

import java.util.Objects;

public class Point {
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

    public void incrementX(int expansionFactor){
        x += expansionFactor;
    }

    public void incrementY(int expansionFactor) {
        y += expansionFactor;
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
}
