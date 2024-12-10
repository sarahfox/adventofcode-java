package com.w3foxes.sarah.Year2023.Day02;

public enum BallColor {
    red(12),
    green(13),
    blue(14);

    public int maxCount;

    BallColor(int maxCount){
        this.maxCount = maxCount;
    }
}
