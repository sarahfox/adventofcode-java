package com.w3foxes.sarah.Year2024.Day06;

import java.util.Objects;

public class Point {
    private int row;
    private int column;

    public Point(int r, int c){
        row = r;
        column = c;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
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
        return Objects.equals(row, comparedTo.getRow())
                && Objects.equals(column, comparedTo.getColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
