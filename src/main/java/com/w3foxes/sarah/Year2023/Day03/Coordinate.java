package com.w3foxes.sarah.Year2023.Day03;

import java.util.Objects;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
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
        Coordinate comparedTo = (Coordinate) o;
        // field comparison
        return Objects.equals(x, comparedTo.x)
                && Objects.equals(y, comparedTo.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
