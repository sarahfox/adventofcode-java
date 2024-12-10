package com.w3foxes.sarah.Year2024.Day06;

public enum Direction {
    UP(-1, 0), 
    DOWN(1, 0), 
    LEFT(0, -1), 
    RIGHT(0, 1); 

    public int nextRowStep;
    public int nextColumnStep;

    Direction(int nextRowStep, int nextColumnStep){
        this.nextRowStep = nextRowStep;
        this.nextColumnStep = nextColumnStep;
    }

    public int getNextRowStep() { return nextRowStep; }
    public int getNextColumnStep() { return nextColumnStep;}

}
