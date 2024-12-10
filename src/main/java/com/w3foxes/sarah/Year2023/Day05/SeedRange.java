package com.w3foxes.sarah.Year2023.Day05;

public class SeedRange {
    long seedNum;
    long rangeLength;

    SeedRange(long seedNum, long rangeLength){
        this.seedNum = seedNum;
        this.rangeLength = rangeLength;
    }

    public long getSeedNum(){ return seedNum;}
    public long getRangeLength() { return rangeLength;}
}
