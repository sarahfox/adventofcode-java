package com.w3foxes.sarah.Year2023.Day05;

public class Range {
    private long fromStart;
    private long toStart;
    private long rangeLength;

    Range(long fromStart, long toStart, long rangeLength){
        this.fromStart = fromStart;
        this.toStart = toStart;
        this.rangeLength = rangeLength;
    }

    public boolean isInRange(long point){
        return point >= fromStart && point <= (fromStart + rangeLength - 1);
    }

    public long convertPoint(long point){
        if(isInRange(point)){
            return point - fromStart + toStart;
        }

        return -1;
    }

    public long getFromStart() { return fromStart;}
    public long getToStart() { return toStart;}
    public long getRangeLength() { return rangeLength;}
}
