package com.w3foxes.sarah.Year2023.Day02;

import java.util.StringTokenizer;

public class BallCount {
    private BallColor color;
    private int count = 0;

    BallCount(String data){
        StringTokenizer st = new StringTokenizer(data, " ", false);
        String countString = st.nextToken();
        String colorString = st.nextToken();

        count = Integer.parseInt(countString);
        color = BallColor.valueOf(colorString);
    }

    public BallColor getColor() { return color; }
    public int getCount() { return count; }

    public boolean isPossible() {
        return count <= color.maxCount;
    }
}
