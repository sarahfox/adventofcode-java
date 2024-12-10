package com.w3foxes.sarah.Year2023.Day10;

import java.util.Objects;

public class Point {
    private long x;
    private long y;
    private PointType type;
    boolean inLoop = false;

    Point(long x, long y, char c) {
        this.x = x;
        this.y = y;
        this.type = PointType.get(c);
    }

    public PointType getPointType() {
        return type;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void setInLoop(boolean inLoop){
        this.inLoop = inLoop;
    }

    public boolean getInLoop(){ return inLoop; }
    
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
