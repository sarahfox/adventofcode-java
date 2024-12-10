package com.w3foxes.sarah.Year2023.Day17;

import java.util.Objects;

public class Node implements Comparable<Node> {
    Point point;
    Direction direction;
    int blocks;
    int tempDistance;

    Node(Point point, Direction direction, int blocks, int tempDistance) {
        this.point = point;
        this.direction = direction;
        this.blocks = blocks;
        this.tempDistance = tempDistance;
    }

    @Override
    public String toString() {
        return point.toString() + " " + direction + " blocks: " + blocks + " distance: " + tempDistance;
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
        Node comparedTo = (Node) o;
        // field comparison
        return point.equals(comparedTo.point) && direction == comparedTo.direction && blocks == comparedTo.blocks;
    }

    @Override
    public int compareTo(Node anotherNode) {
        return compare(this, anotherNode);
    }

    // This is only going to be used for sorting nodes in the unsettled list, so
    // compare first on the distance
    public static int compare(Node n1, Node n2) {
        if (n1.tempDistance != n2.tempDistance) {
            return ((Integer) n1.tempDistance).compareTo(n2.tempDistance);
        }

        if (n1.equals(n2)) {
            return 0;
        } else {
            if (n1.point.equals(n2.point)) {
                if (n1.direction == n2.direction) {
                    return (n1.blocks < n2.blocks) ? -1 : ((n1.blocks == n2.blocks) ? 0 : 1);
                }

                return n1.direction.compareTo(n2.direction);
            } else {
                return n1.point.compareTo(n2.point);
            }

        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, direction, blocks);
    }

    public boolean isDoublingBack(Direction heading) {
        // Check if the new direction is opposite the previous one
        if ((direction == Direction.LEFT && heading == Direction.RIGHT)
                || (direction == Direction.RIGHT && heading == Direction.LEFT)
                || (direction == Direction.UP && heading == Direction.DOWN)
                || (direction == Direction.DOWN && heading == Direction.UP)) {
            return true;
        }

        return false;
    }
}
